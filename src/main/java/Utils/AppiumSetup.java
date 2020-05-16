package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumSetup {

    public static AppiumDriverLocalService service;
    public static AndroidDriver driver;

    public void init() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        caps.setCapability(MobileCapabilityType.UDID, "WE004149");

        try {
            AppiumServiceBuilder start;
            start = new AppiumServiceBuilder().withCapabilities(caps).withIPAddress("127.0.0.1").usingPort(4723);
            service = start.build();
            service.start();
            driver = new AndroidDriver<WebElement>(service.getUrl(), caps);
        }catch (Exception e){
            System.out.println("Error connecting Appium: " + e.getMessage());
        }
    }

    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}