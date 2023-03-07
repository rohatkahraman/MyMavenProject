package technostudyB7.day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {
    public static void main(String[] args) {
        /*
       CSS= tagName[attribute='value']
         */

        // tagName[@attribute='value'] relative XPath

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.worldometers.info/world-population/");
        WebElement worldPopulationTitle = driver.findElement(By.xpath("//div[@id='maincounter-wrap']//h1"));
        System.out.println(worldPopulationTitle.getText());

        WebElement worldPopulationNumber = driver.findElement(By.xpath("//span[@class='rts-counter']"));
        System.out.println(worldPopulationNumber.getText());
    }
}
