package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import lib.ui.PlatformSelector;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class CoreTestCase {

    protected AppiumDriver<WebElement> driver;
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    @Before
    public void setUp() throws Exception {
        URL URL = new URL(APPIUM_URL);


            this.driver = new AndroidDriver<WebElement>(URL, this.getAndroidDesiredCapabilities());

    }

    @After
   public void tearDown() {
       this.driver.quit();
   }

    private DesiredCapabilities getAndroidDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("avd","ver10");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","10.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","\\Users\\Alexey\\Desktop\\Учеба IT\\QAJA_MOBILE\\apps\\org.wikipedia.apk");
        return capabilities;
    }


}
