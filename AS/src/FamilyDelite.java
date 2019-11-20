//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.SwipeElementDirection;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class FamilyDelite {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "FamilDelite";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testFamilDelite() {
        driver.swipe(375, 712, 375, -425, 1453);
        driver.swipe(375, 712, 375, -425, 1453);
        driver.findElement(By.xpath("//*[@text='VIEW ALL' and @class='android.widget.Button']")).click();
        driver.swipe(397, 300, 397, -2150, 1362);
        driver.swipe(397, 300, 397, -2150, 1362);
        driver.swipe(397, 300, 397, -2150, 1362);
        driver.swipe(397, 300, 397, -2150, 1362);
        driver.swipe(397, 300, 397, -2150, 1362);
        driver.swipe(397, 300, 397, -2150, 1362);
        driver.findElement(By.xpath("//*[@text='Star Family Delite Insurance Policy A health insurance plan meant for families with multiple benefits.']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Premium starts from']")));
        String text1 = driver.findElement(By.xpath("//*[@text='₹ 2,800/Year']")).getText();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}