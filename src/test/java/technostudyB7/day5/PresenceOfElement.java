package technostudyB7.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PresenceOfElement {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.seleniumeasy.com");

        //<a href="/testng-tutorials" title="" class="active-trail active">TestNG</a>

        WebElement testNGButton = driver.findElement(By.linkText("TestNG"));
        testNGButton.click();

        //<div class="section-title">
        //        <h1>TestNG Tutorials</h1>
        //		</div>
        WebElement sectionTitle = driver.findElement(By.cssSelector(".section-title>h1"));

        WebDriverWait wait =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".section-title>h1")));
        System.out.println(sectionTitle.getText());





    }
}
