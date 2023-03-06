package SeleniumProjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FacebookSignUp {
    /**
     * Step 1- Create your user stories for each part of the sign-up functionality
     * Step 2- Based on your user stories create your test cases and test scenarios
     * Step 3- Based on your test cases start the test execution manually
     * Step 4- Write your codes on Maven Project and automate your test cases.
     * <p>
     * Summary of the Task :
     * // Navigate https://www.facebook.com/
     * // Click on Create New Account button
     * // Fill the form
     * // Get text for Sign Up button
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com/");
        //<a role="button" class="_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy" href="#"
        // ajaxify="/reg/spotlight/" id="u_0_0_8F" data-testid="open-registration-form-button"
        // rel="async">Create new account</a>
        WebElement createNAButton = driver.findElement(By.cssSelector("a[ajaxify='/reg/spotlight/']"));
        createNAButton.click();
        //<input type="text" class="inputtext _58mg _5dba _2ph-" data-type="text"
        // name="firstname" value="" aria-required="true" placeholder=""
        // aria-label="First name" id="u_2_b_xu" tabindex="0" aria-describedby="js_em" aria-invalid="true">
        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("John");
        //<input type="text" class="inputtext _58mg _5dba _2ph-" data-type="text"
        // name="lastname" value="" aria-required="true" placeholder=""
        // aria-label="Last name" id="u_2_d_Ar">
        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys("Doe");
        // <input type="text" class="inputtext _58mg _5dba _2ph-" data-type="text" name="reg_email__"
        // value="" aria-required="true" placeholder="" aria-label="Mobile number or email" id="u_2_g_re">
        WebElement email = driver.findElement(By.cssSelector("input[name='reg_email__']"));
        email.sendKeys("johndoe@gmail.com");
        //<input type="password" class="inputtext _58mg _5dba _2ph-" data-type="password"
        // autocomplete="new-password" name="reg_passwd__" id="password_step_input"
        // aria-required="true" placeholder="" aria-label="New password">
        WebElement password = driver.findElement(By.cssSelector("input[name='reg_passwd__']"));
        password.sendKeys("123456");
        // <select aria-label="Month" name="birthday_month" id="month" title="Month"
        // class="_9407 _5dba _9hk6 _8esg"><option value="1">Jan</option><option
        // value="2">Feb</option><option value="3" selected="1">Mar</option><option
        // value="4">Apr</option><option value="5">May</option><option value="6">Jun</option><option
        // value="7">Jul</option><option value="8">Aug</option><option value="9">Sep</option><option
        // value="10">Oct</option><option value="11">Nov</option><option value="12">Dec</option></select>
        WebElement monthDropdown = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText("Apr");
        //lots of codes for days
        WebElement dayDropdown = driver.findElement(By.id("day"));
        Select selectDay = new Select(dayDropdown);
        selectDay.selectByValue("21");
        //lots of codes again//
        WebElement yearDropdown = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText("1990");

        //<input type="radio" class="_8esa" name="sex" value="2" id="u_2_5_hl">

        WebElement maleRadio = driver.findElement(By.cssSelector("input[value='2']"));
        maleRadio.click();

        //<button type="submit" class="_6j mvm _6wk _6wl _58mi _3ma _6o _6v" name="websubmit" id="u_2_s_Ld">Sign Up</button>
        WebElement signUpButton = driver.findElement(By.cssSelector("button[name='websubmit']"));
        String signUpButtonText = signUpButton.getText();
        System.out.println(signUpButtonText);

        driver.quit();


    }
}
