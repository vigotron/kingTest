package Steps;

import Utils.InstallApk;
import cucumber.api.java.en.Given;

import java.io.IOException;

public class InstallApkSteps {

    @Given("Wallapop apk has been installed and launched")
    public void installAndLaunchWallapop() throws IOException {
        InstallApk installWallapop = new InstallApk();
        installWallapop.installWallapop();
    }
}