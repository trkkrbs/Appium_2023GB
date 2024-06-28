package techproed.d06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;
import techproed.utilities.ReusableMethods;

// Asagidaki linkten appium mobile gestures github kodlarina erisebilirsiniz.
// https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md

public class C07_ClickGesture extends ApiDemosBaseTest {

    // os.click(); normalde bu sekilde elemente click islemini gerceklestirebiliyoruz
    // fakat mobil cihazlarda bazen click islemleri websitelerde oldugu sekilde calismayabiliyor.
    // Bu yuzden click(), longClick(), doubleClick(), drag(), swipe() vb. gesture islemleri icin;
    // asagida hazir method var bu method'da hangi gesture islemini yapacaksak onun ismini ve
    // tanimladigimiz elementin ismini degiskenlerin oldugu yere yazarak calistiriyoruz.
    @Test
    public void testClickGesture() throws InterruptedException {
        WebElement os = driver.findElement(AppiumBy.accessibilityId("OS"));
//        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) os).getId()
//        ));
        clickGesture(driver, os);
        Thread.sleep(3000);
    }
    @Test
    public void testClickGestureCoordinate() throws InterruptedException {
//        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
//                "x", 683,
//                "y", 1743
//        ));
        clickGesture(driver, 683, 1743);
        Thread.sleep(3000);
    }
}
