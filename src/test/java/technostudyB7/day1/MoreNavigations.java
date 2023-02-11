package technostudyB7.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoreNavigations {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.seleniumeasy.com/");
        //System.out.println("The title of Selenium Easy page is: " + driver.getTitle());

        String expectedTitle = "Selenium Easy - Best Demo website to practice Selenium Webdriver Online";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("The title of SeleniumEasy is: " + actualTitle);
            System.out.println("Verification is complete: PASS");
        } else {
            System.out.println("Verification is FAILED");
            System.out.println("The title of Selenium Easy is: " + actualTitle);
        }
        Thread.sleep(3000);

        String teslaURL = "https://www.tesla.com/";
        driver.navigate().to(teslaURL);
        driver.manage().window().maximize();

        Thread.sleep(5000);

        driver.close(); //closes only one page
        driver.quit(); // closes all pages
    }


}

