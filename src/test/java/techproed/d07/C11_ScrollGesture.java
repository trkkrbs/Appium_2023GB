package techproed.d07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

// Asagidaki linkten appium mobile gestures github kodlarina erisebilirsiniz.
// https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md

public class C11_ScrollGesture extends ApiDemosBaseTest {

    @Test
    public void testScrollToElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Layouts\"))"));

        Thread.sleep(5000);
    }


    @Test
    public void testScrollGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));

        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "percent", 2.0, // 1.0 olarak birakirsak  %100 anlamina geliyor. 0.5 yaparsak %50 scroll yapar. Yani elementin kapladigi alan kadar scroll islemi gerceklesiyor.
                "speed", 500 // The default value is 5000 * displayDensity
        ));

        Thread.sleep(5000);
    }

    @Test
    public void testScrollGestureElementCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 300, "top", 300, "width", 1100, "height", 1200,
                "direction", "down",
                "percent", 1.0, // 1.0 olarak birakirsak  %100 anlamina geliyor. 0.5 yaparsak %50 scroll yapar. Yani elementin kapladigi alan kadar scroll islemi gerceklesiyor.
                "speed", 500 // The default value is 5000 * displayDensity
        ));

        Thread.sleep(5000);
    }

    @Test
    public void testCanScrollMoreGestureElementCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        boolean canScrollMore = true;
        while (canScrollMore) {
            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 300, "top", 300, "width", 1100, "height", 1200,
                    "direction", "down",
                    "percent", 1.0, // 1.0 olarak birakirsak  %100 anlamina geliyor. 0.5 yaparsak %50 scroll yapar. Yani elementin kapladigi alan kadar scroll islemi gerceklesiyor.
                    "speed", 500 // The default value is 5000 * displayDensity
            ));
        }

        Thread.sleep(5000);
    }


}
