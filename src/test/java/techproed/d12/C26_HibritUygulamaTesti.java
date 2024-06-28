package techproed.d12;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

import java.util.Set;

public class C26_HibritUygulamaTesti extends ApiDemosBaseTest {
    @Test
    public void testHibrit() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
        scrollToText(driver, "WebView");
        driver.findElement(AppiumBy.accessibilityId("WebView")).click();

        bekle(2);

        Set<String> contextHandles = driver.getContextHandles();
        for (String contextName : contextHandles){
            System.out.println(contextName);
        }

        driver.context("WEBVIEW_io.appium.android.apis");
        // Webalanina gecis yaptigimizda Website testlerinde yaptigimiz gibi oncelikle o sayfanin windowHandle degerini girmeliyiz.
        // Yoksa sayfada herhangi bir elemente islem yapamayiz. Yukaridaki for dongusu ile hangi handle degerlerine sahip oldugumuzu gozlemleyebiliriz.

        // chromedriver.chromium.org/downloads       ==> bu sitede hangi chrome driver surumununu indirmek istersek bulabiliriz.

        /*
        Testi calistirdigimizda eger "ChromeDriver bulunamadi" seklinde bir hata mesaji alirsak, server'i asagidaki komut ile calistirip,
        testi tekrar calistiririz. Boylece chromedriver bilgisayarimiza otomatik olarak yuklenir.
        appium --allow-insecure chromedriver_autodownload
         */


        System.out.println("URL = " + driver.getCurrentUrl());

        System.out.println("Baslik = " + driver.findElement(By.tagName("h1")).getText());

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        driver.context("NATIVE_APP");

        driver.findElement(AppiumBy.accessibilityId("Visibility")).click();

        bekle(2);

        // chrome://inspect/  google chrome'da bu linke tiklayarak bagli cihazlari ve cihazda acik olan web sayfalarini gorebiliyoruz.
        // emulator de web sayfasina gectikten sonra inspect yazisina tiklayarak emulator benzeri bir sayfanin acilmasini sagliyoruz.






    }
}
