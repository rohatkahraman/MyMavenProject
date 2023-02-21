package technostudyB7.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitlyWait {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Above code: if the element found in a shorter time program will keep running immediately
        /*
        visit the page
        get the hidden text "Hello World"
         */


        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        //<div id="start" style="display: none;">
        //    <button>Start</button>
        //  </div>
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();


        // boolean isHiddenTextDisplayedBeforeCLick = hiddenText.isDisplayed();
        // System.out.println("Hidden text displayed before the button is clicked: "+isHiddenTextDisplayedBeforeCLick);
        //<div id="finish" style=""><h4>Hello World!</h4></div>

        WebElement hiddenText = driver.findElement(By.cssSelector("#finish>h4"));
        String result = hiddenText.getText();
        System.out.println(result);
    }
}
