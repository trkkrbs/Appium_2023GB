package techproed.d02;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class C03_Locators extends ApiDemosBaseTest {

    @Test
    public void testLocators() throws MalformedURLException {
        //1- accessibilityId:
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("Accessibility ID : " + element.getText());

        //2- id:
        element = driver.findElements(AppiumBy.id("android:id/text1")).get(1);
        System.out.println("ID : " + element.getText());

        //3- className:
        element = driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
        System.out.println("className : " + element.getText());

        //4- androidUIAutomator:
        driver.findElement((AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")")));
        System.out.println("Android UI Automator : " + element.getText());

        //5- xpath:
        element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
        element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Accessibility\"]"));
        System.out.println("XPath : " + element.getText());


    }
}
