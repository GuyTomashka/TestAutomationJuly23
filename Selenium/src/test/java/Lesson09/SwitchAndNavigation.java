package Lesson09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



    public class SwitchAndNavigation {
        WebDriver driver;
        String output;

        @BeforeClass
        public void startSession() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://atidcollege.co.il/Xamples/ex_switch_navigation.html");
        }

        @Test
        public void test01() {
            driver.findElement(By.id("btnAlert")).click();
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert text is: " + alertText);
            alert.accept();
            String expectedAlertText = "Alert is gone";
            String actualAlertText =driver.findElement(By.id("output")).getText();
            Assert.assertEquals(actualAlertText, expectedAlertText);
        }

        @Test
        public void test02() {
            String keyword="Selenium";
            driver.findElement(By.id("btnPrompt")).click(); // Corrected this line to click the button
            Alert prompt = driver.switchTo().alert();
            System.out.println("Prompt text is: " + prompt.getText()); // Added missing parenthesis
            prompt.sendKeys(keyword);
            prompt.accept();
            String actualPromptText=driver.findElement(By.id("output")).getText();
            Assert.assertEquals(actualPromptText, keyword);

        }

        @Test
        public void test03(){
            driver.findElement(By.id("btnConfirm")).click();
            Alert popup = driver.switchTo().alert();
            popup.accept();
            String expectedMessage="Confirmed.";
            String actualMessage=driver.findElement(By.id("output")).getText();
            Assert.assertEquals(actualMessage, expectedMessage);
        }

        @Test
        public void  test04(){
            driver.findElement(By.id("btnConfirm")).click();
            Alert popup = driver.switchTo().alert();
            popup.dismiss();
            String expectedMessage="Rejected!";
            String actualMessage=driver.findElement(By.id("output")).getText();
            Assert.assertEquals(actualMessage, expectedMessage);

        }

        @Test
        public void test05(){
            driver.findElement(By.id("btnNewTab")).click();
            String originalTab = driver.getWindowHandle();
            for (String tab : driver.getWindowHandles()) {
                driver.switchTo().window(tab);

            }
            String tabText=driver.findElement(By.id("new_tab_container")).getText();
            driver.close();
            driver.switchTo().window(originalTab);
            String expectedHomeTitle="Switch and Navigate";
            String actualHomeTitle=driver.findElement(By.id("title")).getText();
            Assert.assertEquals(expectedHomeTitle, actualHomeTitle);


        }
        @AfterClass
        public void closeSession(){
            driver.quit();
        }


    }




