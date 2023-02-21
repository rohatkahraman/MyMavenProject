package technostudyB7.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetNotPresentElement {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
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

        Thread.sleep(7000); // gotta wait to get the loaded result


        // boolean isHiddenTextDisplayedBeforeCLick = hiddenText.isDisplayed();
        // System.out.println("Hidden text displayed before the button is clicked: "+isHiddenTextDisplayedBeforeCLick);
         //<div id="finish" style=""><h4>Hello World!</h4></div>

        WebElement hiddenText = driver.findElement(By.cssSelector("#finish>h4"));
        String result = hiddenText.getText();
        System.out.println(result);
    }
}
