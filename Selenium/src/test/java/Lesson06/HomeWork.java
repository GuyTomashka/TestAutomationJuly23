package Lesson06;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeWork {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test01() {
        driver.get("http://google.com");
        driver.get("http://bing.com");
        driver.navigate().back();
        System.out.println("Title is: " + driver.getTitle());

        if (driver.getPageSource().contains("bubble"))
            System.out.println("Exists");
        else
            System.out.println("Not Exists");
    }

    @AfterClass
    public void closeSession() {
        driver.quit();
    }
}
