package Steps;

import Pages.HomeScreen;
import Pages.Login;
import Utils.AppiumSetup;
import Utils.TestResultsReporter;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginSteps {

    @And("the user has opened pre-login page")
    public void theUserHasOpenedPreLoginPage() {
        Login preloginPageIsOpen = new Login();
        Assert.assertTrue(preloginPageIsOpen.preloginPageIsOpen());
    }

    @And("the user has selected Continue with Facebook")
    public void theUserSelectsButtonContinueWithFacebook() {
        Login continueFacebookLogin = new Login();
        continueFacebookLogin.continueFacebookLogin();
    }

    @When("the user types valid Facebook credentials and taps login button")
    public void theUserTypesValidFacebookCredentialsAndTapsLoginButton() throws IOException {
        Properties loadUserData = new Properties();
        loadUserData.load(new FileInputStream("env.properties"));
        String userName = loadUserData.getProperty("userEmail");
        String userPass = loadUserData.getProperty("userPass");
        Login loginWithFacebook = new Login();
        loginWithFacebook.loginWithFacebook(userName, userPass);
    }

    @Then("the user will be successfully logged in")
    public void theUserWillBeSuccessfullyLoggedIn() {
        HomeScreen userIsLoggedIn = new HomeScreen();
        Assert.assertTrue(userIsLoggedIn.userIsLoggedIn());
    }

    @After
    public void close() {
        AppiumSetup appiumSetup = new AppiumSetup();
        appiumSetup.close();
        TestResultsReporter.testResultsToJira();

    }
}