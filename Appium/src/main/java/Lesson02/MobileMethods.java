package Lesson02;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class MobileMethods {

    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeClass
    public void setUp() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, "G0W19D0402560C58");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.apis");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }


    @Test
    public void test01_verifyTotalItems(){
        List<AndroidElement> items=driver.findElements(By.id("text1"));
        System.out.println("Total items: "+items.size());
        Assert.assertEquals(items.size(),11);
    }

    @Test
    public void test02_printDetails(){
        AndroidElement contentElement=driver.findElement(By.xpath("//*[@contentDescription='Content']"));
        System.out.println("Element 'Content' Height: "+contentElement.getRect().getHeight());
        System.out.println("Element 'Content' Width: "+contentElement.getRect().getWidth());
        System.out.println("Element 'Content' X Coordinate: "+contentElement.getRect().getX());
        System.out.println("Element 'Content' Y Coordinate: "+contentElement.getRect().getY());

    }

    @Test
    public void test03_printDeviceInformation(){
        System.out.println("App's activity: "+driver.currentActivity());
        System.out.println("Device Time: "+driver.getDeviceTime());

    }


}
