package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class InstallApk extends AppiumSetup {

    private final String wallapopCloseButtonId = "com.wallapop:id/close";

    public void installWallapop() throws IOException {
        AppiumSetup appiumSetup = new AppiumSetup();
        try {
            appiumSetup.init();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Properties load = new Properties();
        load.load(new FileInputStream("env.properties"));
        File apkWallapop = new File(load.getProperty("apksPath"), load.getProperty("wallapopApkName"));
        apkInstaller(apkWallapop.getAbsolutePath());
        assert driver.findElementById(wallapopCloseButtonId).isDisplayed();
    }
    private void apkInstaller(String apk) {
        DesiredCapabilities installWallapop = new DesiredCapabilities();
        installWallapop.setCapability(MobileCapabilityType.APP, apk);
        driver = new AndroidDriver<WebElement>(service.getUrl(), installWallapop);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}