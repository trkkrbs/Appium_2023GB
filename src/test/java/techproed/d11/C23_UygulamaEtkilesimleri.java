package techproed.d11;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

import java.io.File;
import java.time.Duration;

public class C23_UygulamaEtkilesimleri extends ApiDemosBaseTest {
    @Test
    public void testTerminateApp() {

        // Emulatorden telefon uygulamasini ac.
        // Yeni terminalde adb shell komutununu yaz ve enter'a bas.
        // Sonra dumpsys window displays | grep -E 'mCurrentFocus' komutunu yaz ve enter'a bas.
        // appPackage ve appActivity icin kullandigimiz degerleri burada kullanacagiz.


        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        bekle(2);
        driver.terminateApp("io.appium.android.apis");// terminateApp methodu ile uygulamayi kapatabiliyoruz.

        bekle(2);
    }

    @Test
    public void testActivateApp() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        bekle(2);
        driver.terminateApp("io.appium.android.apis");
        bekle(2);
        driver.activateApp("com.google.android.calculator"); // Kapali olan uygulamiyi bu komutla acabiliyoruz,
        bekle(2);
        driver.activateApp("io.appium.android.apis");
        bekle(2);
    }

    @Test
    public void testRunAppInBackground() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        bekle(2);

        driver.runAppInBackground(Duration.ofSeconds(5));
        bekle(2);
    }

    @Test
    public void testInstallApp() {

        String appUrl = System.getProperty(("user.dir"))
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";

        driver.installApp(appUrl);
        bekle(2);

    }

    @Test
    public void testisAppInstalled() {
        System.out.println(driver.isAppInstalled("com.saucelabs.mydemoapp.rn"));

        String appUrl = System.getProperty(("user.dir"))
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";

        driver.installApp(appUrl);

        System.out.println(driver.isAppInstalled("com.saucelabs.mydemoapp.rn"));
    }

    @Test
    public void testQueryAppState() {
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        bekle(3);

        driver.terminateApp("io.appium.android.apis");
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        bekle(3);

        driver.activateApp("io.appium.android.apis");
        bekle(1);
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        bekle(3);

        driver.activateApp("com.google.android.calculator");
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        bekle(3);


    }
}
