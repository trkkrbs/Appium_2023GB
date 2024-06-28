package techproed.d06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

// Asagidaki linkten appium mobile gestures github kodlarina erisebilirsiniz.
// https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md

public class C09_LongClickGesture extends ApiDemosBaseTest {

    @Test
    public void testLongClickGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();
        WebElement longPressMe = driver.findElement(AppiumBy.accessibilityId("Long press me"));

//        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) longPressMe).getId(),
//                "duration", 1000
//        ));

        longClickGesture(driver, longPressMe, 1000);
        Thread.sleep(2000);
    }

    @Test
    public void testLongClickGestureElementCoodinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();

//        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
//                "x", 722,
//                "y", 553,
//                "duration", 1000
//        ));
        longClickGesture(driver, 722, 553, 1000);
        Thread.sleep(2000);
    }
}
