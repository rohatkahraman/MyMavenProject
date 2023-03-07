package technostudyB7.day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;


public class XPath2 {
    public static void main(String[] args) {
        /**
         * go to "https://www.saucedemo.com/"
         * login with valid credentials
         * click on Sauce Labs Backpack and add to the cart
         * click on back to products
         * click on sauce labs bolt t-shirt and add to the cart
         * click on the cart
         * click on the checkout button
         * fill in the form and click on Continue
         * check if you see your products\
         **/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://www.saucedemo.com/");

        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameInput.sendKeys("standard_user");


        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@data-test='login-button']"));
        loginButton.click();

        WebElement sauceLabsBackpack = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String sauceLabsBackpackStr = sauceLabsBackpack.getText();
        sauceLabsBackpack.click();

        WebElement backpackAddToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        backpackAddToCartButton.click();

        driver.navigate().back();

        WebElement sauceLabsTShirt = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
        String sauceLabsTShirtStr = sauceLabsTShirt.getText();
        sauceLabsTShirt.click();

        WebElement tShirtAddToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
        tShirtAddToCartButton.click();

        WebElement cartButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartButton.click();

        WebElement checkoutButton = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkoutButton.click();

        WebElement firstnameInput = driver.findElement(By.xpath("//input[@id='first-name']"));
        firstnameInput.sendKeys("John");

        WebElement lastnameInput = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastnameInput.sendKeys("Doe");

        WebElement zipcodeInput = driver.findElement(By.xpath("//input[@id='postal-code']"));
        zipcodeInput.sendKeys("98000");

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        WebElement checkoutBackpack = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        WebElement checkoutTShirt = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[2]"));

        List<String> checkoutList = new ArrayList<>();
        checkoutList.add(checkoutBackpack.getText());
        checkoutList.add(checkoutTShirt.getText());

        System.out.println(checkoutList.contains(checkoutBackpack.getText()));
        System.out.println(checkoutList.contains(checkoutTShirt.getText()));

        driver.quit();


    }



}
