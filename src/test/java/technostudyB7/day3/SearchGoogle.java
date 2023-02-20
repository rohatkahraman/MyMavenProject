package technostudyB7.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchGoogle {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        /*
        go to google page
        locate search box
        send bamboo pen keys to the box
        get the title of the new opened page
        verification
         */
        driver.get("https://www.google.com/");
        /*
        <input class="gLFyf" jsaction="paste:puy29d;" maxlength="2048" name="q" type="text"
         aria-autocomplete="both" aria-haspopup="false" autocapitalize="off" autocomplete="off"
          autocorrect="off" autofocus="" role="combobox" spellcheck="false" title="Search" value=""
          aria-label="Search" data-ved="0ahUKEwiVwdqX8qP9AhVSLkQIHVjZDFIQ39UDCAY">
         */
        String key = "bamboo pen";
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(key + Keys.ENTER);

        String expectedTitle = "bamboo pen - Google Search";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Verification is successful: PASS");
            driver.quit();
        } else {
            System.out.println("Verification FAILED");
            System.out.println("The actual title is: " + actualTitle);
            driver.quit();

        }


    }
}
