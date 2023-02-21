package technostudyB7.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlert {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

//        //<button onclick="jsAlert()">Click for JS Alert</button>
//        WebElement clickButtonForJSAlert = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
//        clickButtonForJSAlert.click();
//
//        //to get the alert message
//        String JSAlertText = driver.switchTo().alert().getText();
//        System.out.println(JSAlertText);
//
//        //to click on ok in the alert
//        driver.switchTo().alert().accept();

//        //<button onclick="jsConfirm()">Click for JS Confirm</button>
//        WebElement clickButtonForJSConfirm = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
//        clickButtonForJSConfirm.click();
//        String JSConfirmText = driver.switchTo().alert().getText();
//        System.out.println(JSConfirmText);

//        driver.switchTo().alert().dismiss();
        //<button onclick="jsPrompt()">Click for JS Prompt</button>
        WebElement clickForJSPrompt = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        clickForJSPrompt.click();

        driver.switchTo().alert().sendKeys("John Doe");
        driver.switchTo().alert().accept();
        driver.quit();


    }
}
