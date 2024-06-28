package techproed.d07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

public class C12_SwipeGesture extends ApiDemosBaseTest {

    @Test
    public void testSwipeGestureElement() throws InterruptedException {
        driver.findElement((AppiumBy.accessibilityId("Views"))).click();
        driver.findElement((AppiumBy.accessibilityId("Gallery"))).click();
        driver.findElement((AppiumBy.accessibilityId("1. Photos"))).click();

        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 1.0,
                "speed",  500
        ));
        Thread.sleep(5000);
    }

    @Test
    public void testSwipeGestureCoordinate() throws InterruptedException {
        driver.findElement((AppiumBy.accessibilityId("Views"))).click();
        driver.findElement((AppiumBy.accessibilityId("Gallery"))).click();
        driver.findElement((AppiumBy.accessibilityId("1. Photos"))).click();

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 200, "top", 400, "width", 1000, "height", 100,
                "direction", "left",
                "percent", 1.0,
                "speed",  500
        ));
        Thread.sleep(5000);
    }
}
