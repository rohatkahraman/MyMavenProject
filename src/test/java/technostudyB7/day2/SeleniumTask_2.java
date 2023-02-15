package technostudyB7.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTask_2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        int num1 = 1;
        String num1ToString = Integer.toString(num1);
        int num2 = 2;
        String num2ToString = Integer.toString(num2);


        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
        //<input type="text" class="form-control"
        // placeholder="Enter value" id="sum1">
        WebElement a = driver.findElement(By.id("sum1"));
        a.sendKeys(num1ToString);
        //<input type="text" class="form-control"
        // placeholder="Enter value" id="sum2">
        WebElement b = driver.findElement(By.id("sum2"));
        b.sendKeys(num2ToString);

        //<button type="button" onclick="return total()"
        // class="btn btn-default">Get Total</button>
        WebElement getTotal = driver.findElement(By.cssSelector("button[onclick='return total()']"));
        getTotal.click();
        int expectedResult = num1 + num2;
        String expectedResultToString = Integer.toString(expectedResult);
        System.out.println(expectedResultToString);
        // <span id="displayvalue">12</span>
        WebElement result = driver.findElement(By.id("displayvalue"));
        String actualResult = result.getText();

        if (expectedResultToString.equals(actualResult)) {
            System.out.println("Verification done: PASSED");
        } else {
            System.out.println("Verification FAILED");
            System.out.println("Actual result is: " + actualResult);
        }
    }
}

