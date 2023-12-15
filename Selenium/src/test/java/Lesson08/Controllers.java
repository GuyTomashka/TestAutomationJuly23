package Lesson08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Controllers {
    WebDriver driver;
    final String myFirstName = "Guy";
    final String myLastName = "Tomashka";

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/members/privates/fsta5/content-selenium/class07-controllers.html");

    }

    @Test
    public void test01() {
        driver.findElement(By.name("firstName")).sendKeys(myFirstName);
        driver.findElement(By.name("lastName")).sendKeys(myLastName);
        Select continent = new Select(driver.findElement(By.id("continents")));
        continent.selectByVisibleText("South America");
        driver.findElement(By.id("submit")).click();

        String sURL = driver.getCurrentUrl();
        boolean containsName = sURL.contains(myFirstName) && sURL.contains(myLastName);

        Assert.assertTrue(containsName, "Name values not found in URL");

        if (containsName) {
            System.out.println("Yalla Maccabi");
        } else {
            System.out.println("No No Sad");
        }
    }
}
