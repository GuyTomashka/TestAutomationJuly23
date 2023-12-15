package Lesson07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class LocatorsEx01 {
    WebDriver driver;
    @BeforeClass
    public void startSession() {
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
    }
        @AfterClass
        public void closeSession() {
            driver.quit();
        }
        @Test
        public void test1VerifyLogo() {
            WebElement way1= driver.findElement(By.className("navbar-brand"));
            WebElement way2= driver.findElement(By.className("navbar-logo"));
            WebElement way3= driver.findElement(By.id("Layer_1"));
            WebElement way4= driver.findElement(By.tagName("svg"));
            System.out.println("way1: " +way1);
            System.out.println("way2: " +way2);
            System.out.println("way3: " +way3);
            System.out.println("way4: " +way4);

        }
        @Test
    public void testTotalLinks(){
       List<WebElement> links= driver.findElements(By.tagName("a"));
            System.out.println("Total Links: "+ links.size());
        }
        @Test
    public void testSeleniumWordUpper(){
            List<WebElement> UpperCase= driver.findElements(By.partialLinkText("Selenium"));
            System.out.println("Total Links Selenium Upper: "+UpperCase.size() );
        }
    @Test
    public void testSeleniumWordlower() {
        List<WebElement> LowerCase = driver.findElements(By.partialLinkText("selenium"));
        System.out.println("Total Links selenium Lower: " + LowerCase.size());
    }
    }