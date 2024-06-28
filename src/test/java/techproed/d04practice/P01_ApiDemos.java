package techproed.d04practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

public class P01_ApiDemos  extends ApiDemosBaseTest {

    /*
    Uygulama:  ApiDemos
    API Demos uygulamasina gir
    Preference secenegine tikla
    3. Preference dependencies secenegine tikla
    WIFI kontrol kutusunu sec
    WIFI settings secenegine tikla
    Acilan ekrandaki basligin WIFI settings oldugunu dogrula
    Metin kutusuna adini yaz
    Tamam butonuna tikla
    */

    @Test
    public void testApiDemos() {
        By preferences = AppiumBy.accessibilityId(("Preference"));
        By preferenceDependencies = AppiumBy.accessibilityId("3. Preference dependencies");
        By wifiCheckBox = AppiumBy.id(("android:id/checkbox"));
        By wifiSettings = AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")");
        By wifiSettingsTitle = AppiumBy.id("android:id/alertTitle");
        By textBox = AppiumBy.className("android.widget.EditText");
        By okButton = By.id("android:id/button1");

        driver.findElement(preferences).click();
        driver.findElement(preferenceDependencies).click();
        driver.findElement(wifiCheckBox).click();
        driver.findElement(wifiSettings).click();
        Assert.assertEquals(driver.findElement(wifiSettingsTitle).getText() , "WiFi settings");
        driver.findElement(textBox).sendKeys("Tarik");
        driver.findElement(okButton).click();

    }
}
