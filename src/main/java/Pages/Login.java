package Pages;

import Utils.AppiumSetup;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Login extends AppiumSetup {

    public void preloginPageIsOpen() {
        MobileElement facebookLoginButton = (MobileElement) driver.findElementById("com.wallapop:id/facebookButton");
        MobileElement googleLoginButton = (MobileElement) driver.findElementById("com.wallapop:id/googleButton");
        MobileElement wallapopRegisterButton = (MobileElement) driver.findElementById("com.wallapop:id/registerButton");
        assert facebookLoginButton.isDisplayed();
        assert googleLoginButton.isDisplayed();
        assert wallapopRegisterButton.isDisplayed();
    }

    public void continueFacebookLogin() {
        MobileElement facebookLoginOption = (MobileElement) driver.findElementById("com.wallapop:id/facebookButton");
        facebookLoginOption.click();
    }

    public void loginWithFacebook(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.Button")));

        List<WebElement> fbUserNameField1 = driver.findElementsByClassName("android.widget.EditText");
        fbUserNameField1.get(0).sendKeys(username);
        fbUserNameField1.get(1).sendKeys(password);
        MobileElement fbUserLoginButton = (MobileElement) driver.findElementByClassName("android.widget.Button");
        fbUserLoginButton.click();

        WebDriverWait waitToBeClickable = new WebDriverWait(driver,15);
        waitToBeClickable.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Button")));
        MobileElement continueLogin = (MobileElement) driver.findElementByClassName("android.widget.Button");
        continueLogin.click();

        MobileElement skipWallapopIntro = (MobileElement) driver.findElementById("com.wallapop:id/skip");
        skipWallapopIntro.click();
        MobileElement acceptTermsOfService = (MobileElement) driver.findElementById("com.wallapop:id/button_agree");
        acceptTermsOfService.click();
    }

    public boolean userIsLoggedIn() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.wallapop:id/wp__profile_frame__iv_profile_thumb")));

        MobileElement userProfileImage = (MobileElement) driver.findElementById("com.wallapop:id/wp__profile_frame__iv_profile_thumb");
        return userProfileImage.isDisplayed();
    }
}