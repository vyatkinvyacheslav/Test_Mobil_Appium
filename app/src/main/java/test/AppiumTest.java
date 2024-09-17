
// This sample code supports Appium Java client >=9
// https://github.com/appium/java-client

import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.net.URL;

public class SampleTest {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:platformName", "Android");
        caps.setCapability("appium:deviceName", "Some name");
        caps.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        caps.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        caps.setCapability("appium:automationName", "uiautomator2");
        caps.setCapability("appium:newCommandTimeout", 3600);
        caps.setCapability("appium:connectHardwareKeyboard", true);

        private URL getUrl () {
            try {
                return new URL("http://127.0.0.1:4723");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        driver = new AndroidDriver(this.getUrl(), caps);
    }

    @Test
    public void sampleTest1() {
        var el2 = driver.findElement(AppiumBy.id("ru.netology.testing.uiautomator:id/userInput"));
        el2.click();
        el2.sendKeys(" ");
        var el3 = driver.findElement(AppiumBy.id("ru.netology.testing.uiautomator:id/buttonChange"));
        el3.click();
        var el4 = driver.findElement(AppiumBy.id("ru.netology.testing.uiautomator:id/textToBeChanged"));
        el4.click();
    }

    @Test
    public void sampleTest2() {
        var el5 = driver.findElement(AppiumBy.id("ru.netology.testing.uiautomator:id/userInput"));
        el5.click();
        el5.sendKeys(" good");
        var el6 = driver.findElement(AppiumBy.id("ru.netology.testing.uiautomator:id/buttonActivity"));
        el6.click();
        var el7 = driver.findElement(AppiumBy.id("ru.netology.testing.uiautomator:id/text"));
        el7.click();
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
