package techproed.d07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

public class C13_FlingGesture extends ApiDemosBaseTest {

    @Test
    public void testFlingGestureElement() throws InterruptedException {
        driver.findElement((AppiumBy.accessibilityId("Views"))).click();

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: flingGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "speed",  10000
        ));
        Thread.sleep(5000);
    }

    @Test
    public void testFlingGestureCoordinate() throws InterruptedException {
        driver.findElement((AppiumBy.accessibilityId("Views"))).click();

        driver.executeScript("mobile: flingGesture", ImmutableMap.of(
                "left", 300, "top", 300, "width", 1100, "height", 1200,
                "direction", "down",
                "speed",  5000
        ));
        Thread.sleep(5000);
    }
}
