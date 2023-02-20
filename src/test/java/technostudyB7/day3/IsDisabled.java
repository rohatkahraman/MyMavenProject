package technostudyB7.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDisabled {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        /*
        visit the page (https://the-internet.herokuapp.com/dynamic_controls)
        locate enable button
        click on the button
        verify
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // <form id="input-example">
        // <input type="text" style="width: 30%;">
        // <button autocomplete="off" type="button" onclick="swapInput()">Disable</button><p id="message">It's enabled!</p><div id="loading" style="display: none;">Wait for it... <img src="/img/ajax-loader.gif"></div><br>
        //       </form>
        WebElement enableButton = driver.findElement(By.cssSelector("#input-example>button"));
        WebElement inputField = driver.findElement(By.cssSelector("input[type='text']")); //#input-example>input
        boolean isInputFieldEnabledBeforeClick = inputField.isEnabled();
        System.out.println("Input field enabled before the button is clicked: " + isInputFieldEnabledBeforeClick);
        enableButton.click();
        Thread.sleep(5000); // gives time to load
        boolean isInputFieldEnabledAfterClick = inputField.isEnabled();
        System.out.println("Input field enabled after the button is clicked: " + isInputFieldEnabledAfterClick);

        driver.quit();


    }
}
