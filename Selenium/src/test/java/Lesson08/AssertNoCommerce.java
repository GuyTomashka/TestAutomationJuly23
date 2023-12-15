package Lesson08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertNoCommerce {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        softAssert = new SoftAssert();
    }

    @Test
    public void testAssertion(){
        WebElement register = driver.findElement(By.linkText("Register"));
        WebElement login = driver.findElement(By.linkText("Log in"));
        WebElement wishList = driver.findElement(By.className("ico-wishlist"));
        WebElement shoppingCart = driver.findElement(By.className("ico-cart"));

        softAssert.assertTrue(register.isDisplayed(), "My god, Register is not displayed");
        softAssert.assertTrue(login.isDisplayed(), "My god, Login is not displayed");
        softAssert.assertFalse(wishList.isDisplayed(), "My god, Wish list is not displayed");
        softAssert.assertTrue(shoppingCart.isDisplayed(), "My god, Shopping Cart is not displayed");

        softAssert.assertAll();


    }
    @AfterClass
    public void closeSession(){
        driver.quit();
    }
}
