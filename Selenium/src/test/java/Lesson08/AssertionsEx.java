package Lesson08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertionsEx {
    WebDriver driver;


    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/bmi/");

    }
    @Test
    public void testBmi(){
        driver.findElement(By.id("weight")).sendKeys("70");
        driver.findElement(By.id("hight")).sendKeys("167");
        driver.findElement(By.id("calculate_data")).click();
        String ExpectedResult = "25";
        String actualBmi=driver.findElement(By.id("bmi_result")).getAttribute("value");

    }

    @Test
    public void verifyCalculateBmi(){
        driver.navigate().refresh();
        WebElement calculateButton=driver.findElement(By.id("calculate_data"));
        System.out.println("Button");
    }
}
