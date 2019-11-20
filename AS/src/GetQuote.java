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

public class GetQuote {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "GetQuote";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "ZH33L2FSB9");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.star.customer_app");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testGetQuote() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='LOGIN']")));
        driver.swipe(283, 445, 283, -1554, 1055);
        driver.swipe(283, 445, 283, -1554, 1055);
        driver.findElement(By.xpath("//*[@text='Get Quote' and @class='android.widget.Button' and ./parent::*[./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Premium starts at ₹7,210/yr']]]]]]")).click();
        driver.findElement(By.xpath("//*[@text='Choose']")).click();
        driver.findElement(By.xpath("//*[@text='Myself and My Spouse']")).click();
        driver.findElement(By.xpath("//*[@id='age']")).sendKeys("25");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Choose']")));
        driver.findElement(By.xpath("//*[@class='android.view.View' and ./*[@class='android.view.View'] and ./*[./*[@id='select-policy_cover']]]")).click();
        driver.findElement(By.xpath("//*[@class='android.view.View' and @text='3 Lakhs' and @index='1']")).click();
        driver.findElement(By.xpath("//*[@id='pincode']")).sendKeys("600045");
        driver.swipe(283, 445, 283, -1554, 1055);
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='GET QUOTE']")));
        driver.findElement(By.xpath("//*[@text='GET QUOTE']")).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Your premium amount is']")));
        String text1 = driver.findElement(By.xpath("//*[@text='₹ 9,352']")).getText();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}