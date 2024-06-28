package techproed.d11;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.KeyInput;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

public class C25_Klavye extends ApiDemosBaseTest {

    @Test
    public void testIsKeyboardShown() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextFields\"))"));
        driver.findElement(AppiumBy.accessibilityId("TextFields")).click();
        System.out.println(driver.isKeyboardShown()); // false

        driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).click();
        System.out.println(driver.isKeyboardShown()); // true

        driver.hideKeyboard();
        System.out.println(driver.isKeyboardShown()); // false


        bekle(2);
    }

    @Test
    public void testKeyEvents() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextFields\"))"));
        driver.findElement(AppiumBy.accessibilityId("TextFields")).click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).click();

        //driver.pressKey(new KeyEvent(AndroidKey.A).withKey(AndroidKey.B).withKey(AndroidKey.C));  Bu sekilde with ile zincirleme calismiyor. Isterseniz arastirin dogrusunu ogrenin.

        //KeyInput keyInput = new KeyInput(AndroidKey.A, AndroidKey.B, AndroidKey.C);
        //driver.pressKey(new KeyEvent(keyInput));      Bu iki satirda calismiyor. Arastir.

        KeyEvent back = new KeyEvent(AndroidKey.BACK);
        driver.pressKey(back);
        bekle(2);

        KeyEvent appSwitch = new KeyEvent(AndroidKey.APP_SWITCH);
        driver.pressKey(appSwitch);
        bekle(2);

        KeyEvent home = new KeyEvent(AndroidKey.HOME);
        driver.pressKey(home);
        bekle(2);

    }
}
