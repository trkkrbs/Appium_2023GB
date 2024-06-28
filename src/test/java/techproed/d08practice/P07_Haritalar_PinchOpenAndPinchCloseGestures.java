package techproed.d08practice;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.HaritalarBaseTest;
import techproed.basetest.KitapyurduBaseTest;

import java.util.List;

// Emulatorden telefon uygulamasini ac
// Yeni terminalde adb shell komutununu yaz ve enter'a bas
// Sonra dumpsys window displays | grep -E 'mCurrentFocus' komutunu yaz ve enter'a bas

// UYGULAMA HARITALAR
// 1. Haritalar uygulamasina gir.
// 2. Harita secenegi olarak Uydu secenegini sec.
// 3. Arama seceneginde Taj Mahal keliemelerini arat
// 4. Haritada Taj Mahal bolgesine zoom in ve zoom out islemlerini yap.

public class P07_Haritalar_PinchOpenAndPinchCloseGestures extends HaritalarBaseTest {

    @Test
    public void testPinchOpenAndClose() throws InterruptedException {
        WebElement haritalarMenu = driver.findElement(AppiumBy.accessibilityId("Layers"));
        clickGesture(driver, haritalarMenu);

        WebElement uydu = driver.findElement(AppiumBy.id("com.google.android.apps.maps:id/layers_menu_satellite_layer"));
        clickGesture(driver, uydu);

        WebElement menuClose = driver.findElement(AppiumBy.accessibilityId("Close menu"));
        clickGesture(driver, menuClose);

        WebElement searchBox = driver.findElement(AppiumBy.accessibilityId("Search here"));
        clickGesture(driver, searchBox);

        WebElement searchHere = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Search here\")"));
        searchHere.sendKeys("Taj Mahal");

        KeyEvent enter = new KeyEvent(AndroidKey.ENTER);
        driver.pressKey(enter);

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 500,
                "top", 700,
                "width", 400,
                "height", 400,
                "percent", 0.75,
                "speed", 300
        ));

        Thread.sleep(2000);

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", 500,
                "top", 700,
                "width", 400,
                "height", 400,
                "percent", 0.75,
                "speed", 300
        ));

        Thread.sleep(5000);
    }
}
