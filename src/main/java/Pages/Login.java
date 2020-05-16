package Pages;

import Utils.AppiumSetup;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Login extends AppiumSetup {

    private final String continueWithFacebookButtonId = "com.wallapop:id/facebookButton";
    private final String registerWallapopButtonId = "com.wallapop:id/registerButton";
    private final String skipWallapopTutorialButtonId = "com.wallapop:id/skip";
    private final String acceptTosButtonId = "com.wallapop:id/button_agree";

    public boolean preloginPageIsOpen() {
        MobileElement wallapopRegisterButton = (MobileElement) driver.findElementById(registerWallapopButtonId);
        return wallapopRegisterButton.isDisplayed();
    }
    public void continueFacebookLogin() {
        MobileElement continueWithFacebookLogin = (MobileElement) driver.findElementById(continueWithFacebookButtonId);
        continueWithFacebookLogin.click();
    }
    public void loginWithFacebook(String username, String password) {
        WebDriverWait waitToDisplay = new WebDriverWait(driver, 15);
        waitToDisplay.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.Button")));

        List<WebElement> facebookCredentialFields = driver.findElementsByClassName("android.widget.EditText");
        facebookCredentialFields.get(0).sendKeys(username);
        facebookCredentialFields.get(1).sendKeys(password);
        MobileElement facebookLoginButton = (MobileElement) driver.findElementByClassName("android.widget.Button");
        facebookLoginButton.click();

        WebDriverWait waitToBeClickable = new WebDriverWait(driver, 15);
        waitToBeClickable.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Button")));
        MobileElement continueAsFacebookUser = (MobileElement) driver.findElementByClassName("android.widget.Button");
        continueAsFacebookUser.click();

        MobileElement skipWallapopIntro = (MobileElement) driver.findElementById(skipWallapopTutorialButtonId);
        skipWallapopIntro.click();
        MobileElement acceptTermsOfService = (MobileElement) driver.findElementById(acceptTosButtonId);
        acceptTermsOfService.click();
    }
}