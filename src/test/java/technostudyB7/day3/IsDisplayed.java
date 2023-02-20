package technostudyB7.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDisplayed {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //<div id="start">
        //    <button>Start</button>
        //  </div>
        //***** after click ******
        //<div id="finish" style="">
        //    <h4>Hello World!</h4>
        //  </div>

        /*TEST CASE
        visit the page
        verify if the hidden text is displayed
        click on the button
        verify if thr hidden text is displayed

         */
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement clickButton = driver.findElement(By.cssSelector("#start>button"));
        WebElement hiddenText = driver.findElement(By.cssSelector("#finish>h4"));
        boolean isHiddenTextDisplayedBeforeClick = hiddenText.isDisplayed();
        System.out.println("Hidden text displayed before the button is clicked: "+isHiddenTextDisplayedBeforeClick);
        clickButton.click();
        Thread.sleep(5000);
        boolean isHiddenTextDisplayedAfterClick = hiddenText.isDisplayed();
        System.out.println("Hidden text displayed after the button is clicked: "+isHiddenTextDisplayedAfterClick);

        driver.quit();



    }
}
