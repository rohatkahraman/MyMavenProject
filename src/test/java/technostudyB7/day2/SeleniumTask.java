package technostudyB7.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTask {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String text = "Hello Selenium";

        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
        //<input autofocus = "" type = "text" class="form-control"
        //placeholder="Please enter your Message"
        // id="user-message">
        WebElement textBox = driver.findElement(By.id("user-message"));
        textBox.sendKeys(text);
        //<button type="button" onclick="showInput();"
        // class="btn btn-default">Show Message</button>
        WebElement showMessage = driver.findElement(By.cssSelector("button[class='btn btn-default']"));
        showMessage.click();
        //<span id="display">Hello Selenium</span>
        WebElement result = driver.findElement(By.id("display"));
        String expectedResult = "Hello Selenium";
        String actualResult = result.getText();
        if (expectedResult.equals(actualResult)) {
            System.out.println("Verification done: PASSED");
        } else {
            System.out.println("Verification FAILED");
            System.out.println("Actual result is: " + actualResult);
        }
    }


}

