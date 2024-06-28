package techproed.d02;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class C02_Capabilities {
    @Test
    public void testUiAutomator2Options() throws MalformedURLException {
        String appUrl = System.getProperty(("user.dir"))
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos-debug.apk";

        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(appUrl)//Calistiracagimiz uygulamayi secmek icin
//                .setUdid("emulator-5554") //Bilgisi icin CMD Komutu: adb devices       setUdid("Cihaz ID'si)  UDID(Unique Device Identifier)
//                .setAppPackage(("io.appium.android.apis")) //Calistiracagimiz uygulamayi secmek icin
//                .setAppActivity(("io.appium.android.apis.ApiDemos")) //Calistiracagimiz uygulamayi secmek icin
                .setAvd("pixel_7_pro") //Kapali Emulatoru acmak icin
                .setAvdLaunchTimeout(Duration.ofMinutes(5)) //Emulatorun acilisinda sure tanimlamasi yapmak icin
                ;

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, options);
    }
}
