package Steps;

import Utils.InstallApk;
import cucumber.api.java.en.Given;

public class InstallApkSteps {

    @Given("Wallapop apk has been installed and launched")
    public void installAndLaunchWallapop() {
        InstallApk installWallapop = new InstallApk();
        installWallapop.installWallapop();
    }
}
