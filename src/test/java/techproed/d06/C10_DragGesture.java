package techproed.d06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

// Asagidaki linkten appium mobile gestures github kodlarina erisebilirsiniz.
// https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md

public class C10_DragGesture extends ApiDemosBaseTest {
    @Test
    public void testDragGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

//        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId(),
//                "endX", 831,
//                "endY", 734,
//                "speed", 500   //speed zorunlu degil ama biz drag(surukleme) islemini gorebilmek icin hizi azaltiyoruz/
//        ));
        dragGesture(driver, element, 831, 734, 500);
        Thread.sleep(2000);
    }


    @Test
    public void testDragGestureElementSpeedCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

//        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
//                "startX", 270,
//                "startY", 730,
//                "endX", 831,
//                "endY", 734,
//                "speed", 500
//        ));
        dragGesture(driver, 270, 730, 831, 734, 500);
        Thread.sleep(2000);
    }
}
