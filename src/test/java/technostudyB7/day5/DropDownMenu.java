package technostudyB7.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownMenu {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        //<select class="form-control" id="select-demo">
        //				<option value="" selected="" disabled="">Please select</option>
        //				 <option value="Sunday">Sunday</option>
        //				  <option value="Monday">Monday</option>
        //				  <option value="Tuesday">Tuesday</option>
        //				  <option value="Wednesday">Wednesday</option>
        //				  <option value="Thursday">Thursday</option>
        //				  <option value="Friday">Friday</option>
        //				  <option value="Saturday">Saturday</option>
        //			  </select>
        WebElement dropdownMenu = driver.findElement(By.id("select-demo"));
        Select dropDown = new Select(dropdownMenu);
        Thread.sleep(1000);
        dropDown.selectByIndex(0); //selects options by index
        Thread.sleep(1000);
        dropDown.selectByVisibleText("Monday"); //value copied from the visible text
        Thread.sleep(1000);

        String selectedOption = dropDown.getFirstSelectedOption().getText();
        System.out.println(selectedOption);
        String expected = "Monday";
        if (selectedOption.equals(expected)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }


//        dropDown.selectByValue("Friday"); // value copied from the element
//        Thread.sleep(1000);
//        dropDown.selectByValue("Thursday"); // value copied from the element
//        Thread.sleep(1000);
//
//        dropDown.selectByIndex(3);
//        Thread.sleep(1000);

    }
}
