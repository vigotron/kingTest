# kingTest

## Appium steps UBUNTU 18.04.4 LTS

1. Nodejs and npm installation
2. Appium + Appium Desktop app installation
3. UIautomator2 driver installation
4. JAVA JDK and ANDROID SDK installation + Config 
5. Install appium-doctor and run to verify installation dependencies

## Real Android device connection with Appium Server

1. Install SDK tools for Android(adb,fastboot etc)
2. Enable developer mode and USB debugging
3. Connect via USB to laptop and accept 
4. Check $adb devices retrieves device ID
5. Start Appium Desktop app
6. Start Appium Server
7. Introduce basic capability for connection -->  platformName:Android
8. Start session

## Framework setup steps 

1. Create repo as private
2. Create a dev branch for initial setup commits 
3. Clone repo in a local folder from cli
4. IntelliJ to create a new Maven project
5. Setup project in repo folder from step 3
7. Add dependencies to POM: java-client,selenium,cucumber, junit
8. Create main/resource/feature folder for BDD scenarios
9. Create main/java/Steps folder for steps definitions
10. Create main/java/Utils package for driver & capabilities setup
11. Create test/Apps folder to store apk resources

