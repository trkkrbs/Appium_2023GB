package techproed.basetest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import techproed.utilities.ReusableMethods;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ApiDemosBaseTest extends ReusableMethods {
    protected AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
//        String appUrl = System.getProperty(("user.dir"))
//                + File.separator + "src"
//                + File.separator + "test"
//                + File.separator + "resources"
//                + File.separator + "ApiDemos-debug.apk";

        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("io.appium.android.apis") // AppPackage & AppActivity ile de cihazimizi calistirabiliriz.
                .setAppActivity("io.appium.android.apis.ApiDemos"); // Boylece yukaridaki kod kalabaligindan kurtulmus oluruz.
        // Ama tabi ki bu 3 satirin calisabilmesi icin uygulamanin mobil cihaza daha onceden yuklenmis olmasi gerekir.

        URL url = new URL("http://0.0.0.0:4723");
        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
