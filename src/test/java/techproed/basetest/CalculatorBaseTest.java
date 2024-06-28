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

public class CalculatorBaseTest extends ReusableMethods {
    protected AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
//        String appUrl = System.getProperty(("user.dir"))
//                + File.separator + "src"
//                + File.separator + "test"
//                + File.separator + "resources"
//                + File.separator + "calculator_8.4.1.apk";       Bu sefer yol ile yapmayacagiz.

//        UiAutomator2Options options = new UiAutomator2Options()
//                .setApp(appUrl)
//                .setUdid("emulator-5558"); // 2 cihaz calistirdigimizda calistiracagimiz cihazin UdId sini belirtmemiz lazim.


        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("com.google.android.calculator") // AppPackage & AppActivity ile de cihazimizi calistirabiliriz.
                .setAppActivity("com.android.calculator2.Calculator"); // Boylece yukaridaki kod kalabaligindan kurtulmus oluruz.
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
