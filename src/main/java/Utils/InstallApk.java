package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;

public class InstallApk extends AppiumSetup {

    String apkWallapop = "/home/vigo/Documents/king_test/kingTest/src/main/java/Utils/Apks/wallapop-1-95-1.apk";

    public void installWallapop() {
        AppiumSetup appiumSetup = new AppiumSetup();
        try {
            appiumSetup.init();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        apkInstaller(apkWallapop);
        assert driver.findElement(By.id("com.wallapop:id/close")).isDisplayed();
    }

    private void apkInstaller(String apk) {
        DesiredCapabilities installWallapop = new DesiredCapabilities();
        installWallapop.setCapability(MobileCapabilityType.APP, apk);
        driver = new AndroidDriver<WebElement>(service.getUrl(), installWallapop);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
