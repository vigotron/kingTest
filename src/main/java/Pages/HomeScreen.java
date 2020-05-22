package Pages;

import Utils.AppiumSetup;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeScreen extends AppiumSetup {

    private final String wallapopProfileImageId = "com.wallapop:id/wp__profile_frame__iv_profile_thumb";

    public boolean userIsLoggedIn() {
        WebDriverWait waitToDisplay = new WebDriverWait(driver, 15);
        waitToDisplay.until(ExpectedConditions.visibilityOfElementLocated(By.id(wallapopProfileImageId)));

        MobileElement wallapopProfileImage = (MobileElement) driver.findElementById(wallapopProfileImageId);
        return wallapopProfileImage.isDisplayed();
    }
}