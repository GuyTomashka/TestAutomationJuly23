package Lesson11;
import static org.testng.Assert.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;


public class ReportingEx {
    private WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/bmi");
    }

    @Test(description = "Verify BMI Result")
    @Description("Test Description:this test calculate the bmi by using weight and height and verify the result")
    public void test01_BMITest() {
        try{
            calculateBmi("147","216");
            verifyBmiResult("32");
        }
        catch (AssertionError e){
            saveScreenshot();
            fail("There was an error - see details:"+e);
        }
    }
    @Step("Enter Weight:")
    public void insertWeight(String weight){
        driver.findElement(By.id("weight")).sendKeys(weight);
    }

    @Step("Enter Height:")
    public void insertHeight(String height){
        driver.findElement(By.name("height")).sendKeys(height);
    }

    @Step("Click on calculate bmi button")
    public void submit(){
        driver.findElement(By.id("calculate_data")).click();
    }
    @Step("Verify Bmi is as expected")
    public void verifyBmiResult(String expectedBmi){
        String actualResult = driver.findElement(By.id("bmi_result")).getAttribute("value");
        Assert.assertEquals(actualResult,expectedBmi);
    }
    @Step("Calculate Bmi Result")
    public void calculateBmi(String weight,String height){
        insertWeight(weight);
        insertHeight(height);
        submit();
    }


    @Attachment(value = "Page Screenshot",type = "image/png")
    public byte[] saveScreenshot(){
        return  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}