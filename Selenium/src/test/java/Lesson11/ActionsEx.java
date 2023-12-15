package Lesson11;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ActionsEx {

    WebDriver driver;
    Actions action;

    @BeforeClass
    public void openBrowser (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_actions.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action = new Actions(driver);


    }

    @Test
    public void test01DragAndDrop(){

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        action.dragAndDrop(draggable,droppable).build().perform();
        assertEquals(droppable.getText(), "Dropped!");

    }
    @Test
    public void test02SelectMultiple() {
        List<WebElement> listItems = driver.findElements(By.xpath("//ol[@id='select_items']/li"));
        action.clickAndHold(listItems.get(1)).clickAndHold(listItems.get(2)).click().build().perform();
    }
    @Test
    public void test03DoubleClick() {
        action.doubleClick(driver.findElement(By.id("dbl_click"))).build().perform();
        assertEquals(driver.findElement(By.id("demo")).getText(), "Hello World");
    }


    @Test
    public void test04_On_MouseHover() {
        WebElement element = driver.findElement(By.id("mouse_hover"));
        action.moveToElement(element).click().build().perform();
        String expectedStyle="background-color: rgb(255, 255, 0);";


    }

    @AfterClass
    public void closeBrowser() {
        Uninterruptibles.sleepUninterruptibly(4,TimeUnit.SECONDS);
        driver.quit();
    }
}
