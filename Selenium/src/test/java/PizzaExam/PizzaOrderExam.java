package PizzaExam;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PizzaOrderExam {
    WebDriver driver;

    @BeforeClass
    public void pizzaTest1(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://atidcollege.co.il/Xamples/pizza");

    }

    @Test
    public void test01VerifyPrice(){
        driver.findElement(By.className("ginput_total ginput_total_5"));



    }
    @AfterClass
    public void closeSession()
    {
        driver.quit();
    }
}
