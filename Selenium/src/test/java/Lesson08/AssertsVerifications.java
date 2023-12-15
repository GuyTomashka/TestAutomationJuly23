package Lesson08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;


public class AssertsVerifications {
    private WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getData("URL"));
    }

    @Test
    public void test01_BMItest() {
        driver.findElement(By.id("weight")).sendKeys(getData("My_Weight"));
        driver.findElement(By.name("height")).sendKeys(getData("My_Height"));
        driver.findElement(By.id("calculate_data")).click();
        String ExpectedResult = getData("Expected_Result");
        String ActualResult = driver.findElement(By.id("bmi_result")).getAttribute("value");
        assertEquals(ActualResult, ExpectedResult);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    public String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("C:\\Automation\\JavaCourse\\TestAutomation\\Config.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();

    }
}
