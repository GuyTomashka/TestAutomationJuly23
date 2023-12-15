package Lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExample {

    private WebDriver driver;
    private final String expectedTitleName = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
    private final String expectedUrlAddress = "https://www.imdb.com/";

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://imdb.com");
    }

    @Test
    public void test01() {
        driver.navigate().refresh();
        String actualTitleName = driver.getTitle();
        System.out.println("Title is: " + actualTitleName);
        String actualUrlAddress = driver.getCurrentUrl();
        System.out.println("Address is: " + actualUrlAddress);

        if (actualTitleName.equals(expectedTitleName))
            System.out.println("Title Test Passed");
        else
            System.out.println("Title Test Failed");

        if (actualUrlAddress.equals(expectedUrlAddress))
            System.out.println("Address Test Passed");
        else
            System.out.println("Address Test Failed");
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void test02() {
        driver.get("https://www.google.com");
        String sUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + sUrl);
        System.out.println("Title is: " + driver.getTitle());
    }

    @Test
    public void test03() {
        driver.get("https://www.imdb.com");
        String sUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + sUrl);
    }
}
