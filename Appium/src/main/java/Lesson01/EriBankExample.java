package Lesson01;

    //package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

    public class EriBankExample {
        final String myUserName="company";
        final String myPassword="company";

        protected AndroidDriver<AndroidElement> driver = null;

        DesiredCapabilities dc = new DesiredCapabilities();

        @BeforeClass
        public void setUp() throws MalformedURLException {
            dc.setCapability(MobileCapabilityType.UDID, "G0W19D0402560C58");
            dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
            dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        @Test
        public void test01Login() {
            driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys(myUserName);
            driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys(myPassword);
            driver.findElement(By.xpath("//*[@id='loginButton']")).click();
            String actualHeader = driver.findElement(By.xpath("//*[contains(text(),'$')]")).getText();
            System.out.println(actualHeader);
            driver.findElement(By.xpath("//*[@id='logoutButton']")).click();
            Assert.assertTrue(actualHeader.contains("Your balance is"));
            driver.runAppInBackground(Duration.ofSeconds(10));


        }

       @AfterClass
        public void tearDown() {
            driver.quit();
        }

}
