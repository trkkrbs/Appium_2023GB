package techproed.d06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;
import techproed.basetest.CalculatorBaseTest;

// Asagidaki linkten appium mobile gestures github kodlarina erisebilirsiniz.
// https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md

public class C08_DoubleClickGesture extends CalculatorBaseTest {

    @Test
    public void testDoubleClickGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("2")).click();

        WebElement element = driver.findElement(AppiumBy.id("com.google.android.calculator:id/formula"));


//        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId()
//        ));
        doubleClickGesture(driver, element);
        Thread.sleep(2000);
    }

    @Test
    public void testDoubleClickGestureCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("2")).click();

//        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
//                "x", 1068,
//                "y", 456
//        ));
        doubleClickGesture(driver, 1068, 456);
        Thread.sleep(2000);
    }
}
