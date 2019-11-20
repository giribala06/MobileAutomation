//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Login {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Login";
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
    public void testLogin() {
    	System.out.println();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='LOGIN']")));
        driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((((//*[@class='android.view.View' and ./parent::*[@id='root']]/*/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View' and ./parent::*[@class='android.view.View']]])[3]/*[@class='android.view.View'])[1]/*[@class='android.view.View'])[2]/*/*/*[@class='android.widget.EditText'])[1]")));
        driver.findElement(By.xpath("((((//*[@class='android.view.View' and ./parent::*[@id='root']]/*/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View' and ./parent::*[@class='android.view.View']]])[3]/*[@class='android.view.View'])[1]/*[@class='android.view.View'])[2]/*/*/*[@class='android.widget.EditText'])[1]")).sendKeys("giribala.rschandran@expleogroup.com");
        new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((((//*[@class='android.view.View' and ./parent::*[@id='root']]/*/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View' and ./parent::*[@class='android.view.View']]])[3]/*[@class='android.view.View'])[1]/*[@class='android.view.View'])[2]/*/*/*[@class='android.widget.EditText'])[2]")));
        driver.findElement(By.xpath("((((//*[@class='android.view.View' and ./parent::*[@id='root']]/*/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View' and ./parent::*[@class='android.view.View']]])[3]/*[@class='android.view.View'])[1]/*[@class='android.view.View'])[2]/*/*/*[@class='android.widget.EditText'])[2]")).sendKeys("Ran@2124");
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='CONTINUE']")));
        driver.findElement(By.xpath("//*[@text='CONTINUE']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='LOGOUT']")));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}