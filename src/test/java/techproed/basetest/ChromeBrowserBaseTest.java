package techproed.basetest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import techproed.utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ChromeBrowserBaseTest extends ReusableMethods {
    protected AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                //.setUdid("Gercek Cihaz Kimlik Bilgisi") //Buraya terminalde yeni sayfa acip adb devices yazarak testlerde kullanacagimiz gercek cihazimizi giriyoruz.
                //Bu islem zorunlu degil sadece iki cihaz kullanarak kopmayi engelliyoruz.
                .withBrowserName("Chrome") //Sadece bu eklenti ile Chrome Browser'a gecis yapabiliyoruz.
                ;


        URL url = new URL("http://0.0.0.0:4723");
        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
