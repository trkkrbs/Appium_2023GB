package techproed.d03;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

public class C06_ElementDegerleriniCekme extends ApiDemosBaseTest {
    @Test
    public void testElementDegerleriniCekme()  {

        By accessibility = AppiumBy.accessibilityId("Accessibility");
        System.out.println("Get Text : " + driver.findElement(accessibility).getText()); //Get Text : Accessibility
        System.out.println("Get Attribute : " + driver.findElement(accessibility).getAttribute("package")); //Get Attribute : io.appium.android.apis
        System.out.println("Get Attribute : " + driver.findElement(accessibility).getAttribute("checkable")); //Get Attribute : false

        System.out.println("isSelected() : " + driver.findElement(accessibility).isSelected()); //isSelected() : false
        System.out.println("isEnabled() : " + driver.findElement(accessibility).isEnabled()); //isEnabled() : true
        System.out.println("isDisplayed() : " + driver.findElement(accessibility).isDisplayed()); //isDisplayed() : true

        System.out.println("getSize() : " + driver.findElement(accessibility).getSize()); //getSize() : (1440, 168)
        System.out.println("getLocation() : " + driver.findElement(accessibility).getLocation()); //getLocation() : (0, 452)


    }
}
