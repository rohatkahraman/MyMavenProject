package Mentoring;

import com.google.common.hash.HashingOutputStream;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class date2142023 {
    public static void main(String[] args) throws InterruptedException {
        /**
         * navigate to "http://tutorialsninja.com/demo/"
         * click on Laptops & Notebooks
         * click on Show all Laptops & Notebooks
         * Sort the products according to their price (Low to High)
         * click on the second one
         * click on add to cart
         * check if you see the success message
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://tutorialsninja.com/demo/");


        WebElement laptopsAndNotebooksButton = driver.findElement(By.linkText("Laptops & Notebooks"));
        laptopsAndNotebooksButton.click();

        WebElement showAllButton = driver.findElement(By.linkText("Show All Laptops & Notebooks"));
        showAllButton.click();

        WebElement sortButton = driver.findElement(By.id("input-sort"));

        Select sortButtonSelect = new Select(sortButton);
        sortButtonSelect.selectByVisibleText("Price (Low > High)");

        WebElement secondItem = driver.findElement(By.linkText("MacBook"));
        secondItem.click();

        WebElement addToCart = driver.findElement(By.id("button-cart"));
        addToCart.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String actualResult = successMessage.getText();
        System.out.println(actualResult);
        //Success: You have added MacBook to your shopping cart!
        String expectedResult = "Success: You have added MacBook to your shopping cart!";

        if (actualResult.contains("Success:")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        driver.quit();


    }
}
