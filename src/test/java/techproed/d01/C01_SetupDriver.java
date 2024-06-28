package techproed.d01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class C01_SetupDriver {

    @Test
    public void testDesiredCapabilities() throws MalformedURLException {
        String appUrl = System.getProperty(("user.dir"))
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos-debug.apk";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android"); //Zorunlu
        capabilities.setCapability("automationName", "uiautomator2"); //Zorunlu
        capabilities.setCapability("app", appUrl);
//        capabilities.setCapability("udid", "emulator-5554"); //Birden fazla uygulama varsa gerekli. Eger tek uygulamada calisiyorsak yoruma alabilirsiniz. Terminalde adb devices komutu calistirarak calistigimiz cihazin UDID'sini alip yapistiryoruz.
//        capabilities.setCapability("appPackage", "io.appium.android.apis");
//        capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, capabilities);
    }

    @Test
    public void testUiAutomator2Options() throws MalformedURLException {
        String appUrl = System.getProperty(("user.dir"))
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos-debug.apk";

        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(appUrl)
//              .setUdid("emulator-5554") //setUdid("Cihaz ID'si)  UDID(Unique Device Identifier) Bilgisi icin CMD Komutu: adb devices
//              .setAppPackage(("io.appium.android.apis"))
//              .setAppActivity(("io.appium.android.apis.ApiDemos"))
                ;

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, options);
    }

    @Test
    public void testTest() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
              .setApp("/Users/parthenia/IdeaProjects/Appium_Upskills_2023_November/src/test/resources/ApiDemos-debug.apk");
//              .setUdid("emulator-5554") //setUdid("Cihaz ID'si)  UDID(Unique Device Identifier) Bilgisi icin CMD Komutu: adb devices
//              .setAppPackage(("io.appium.android.apis"))
//              .setAppActivity(("io.appium.android.apis.ApiDemos"));

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, options);
    }
}
