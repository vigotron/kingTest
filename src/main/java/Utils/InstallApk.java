package Utils;

public class InstallApk extends AppiumSetup {

    public void installWallapop() {
        AppiumSetup appiumSetup = new AppiumSetup();
        try {
            appiumSetup.init();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
