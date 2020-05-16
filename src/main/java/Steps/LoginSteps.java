package Steps;

import Pages.Login;
import Utils.AppiumSetup;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

    @And("the user has opened pre-login page")
    public void theUserHasOpenedPreLoginPage() {
        Login preloginPageIsOpen = new Login();
        preloginPageIsOpen.loginPageIsDisplayed();
    }

    @And("the user selects button Continue with Facebook")
    public void theUserSelectsButtonContinueWithFacebook() {
        Login selectFacebookLogin = new Login();
        selectFacebookLogin.selectFacebookLogin();
    }

    @When("the user types valid Facebook credentials and taps login button")
    public void theUserTypesValidFacebookCredentialsAndTapsLoginButton() {
        String username = "vigotest78@gmail.com";
        String pass = "VigoTest_2020";
        Login loginWithFacebook = new Login();
        loginWithFacebook.facebookUserLogin(username,pass);
    }

    @Then("the user will be successfully logged in")
    public void theUserWillBeSuccessfullyLoggedIn() {
        Login userIsLoggedIn = new Login();
        assert userIsLoggedIn.isUserLoggedIn();
    }

    @After
    public void close(){
        AppiumSetup appiumSetup = new AppiumSetup();
        appiumSetup.close();
    }
}