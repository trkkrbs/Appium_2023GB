package techproed.d08practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.TelefonBaseTest;

// Emulatorden telefon uygulamasini ac
// Yeni terminalde adb shell komutununu yaz ve enter'a bas
// Sonra dumpsys window displays | grep -E 'mCurrentFocus' komutunu yaz ve enter'a bas

// UYGULAMA TELEFON
// 1. Telefon uygulamasina gir.
// 2. +905304861275 numarasini ara.
// 3. Mesajda, Arama basarisiz oldu. metnini dogrula.
// 4. Tamam butonuna bas.

public class P05_Telefon_LongClickGesture extends TelefonBaseTest {

    @Test
    public void testLongClickGesture() {

        By keyPad = AppiumBy.accessibilityId("key pad");
        By bir = AppiumBy.accessibilityId("1,");
        By iki = AppiumBy.accessibilityId("2,ABC");
        By uc = AppiumBy.accessibilityId("3,DEF");
        By dort = AppiumBy.accessibilityId("4,GHI");
        By bes = AppiumBy.accessibilityId("5,JKL");
        By alti = AppiumBy.accessibilityId("6,MNO");
        By yedi = AppiumBy.accessibilityId("7,PQRS");
        By sekiz = AppiumBy.accessibilityId("8,TUV");
        By dokuz = AppiumBy.accessibilityId("9,WXYZ");
        By sifir = AppiumBy.accessibilityId("0");
        By ara = AppiumBy.accessibilityId("dial");

        clickGesture(driver, driver.findElement(keyPad));
        longClickGesture(driver, driver.findElement(sifir), 1000);
        longClickGesture(driver, driver.findElement(dokuz));
        longClickGesture(driver, driver.findElement(sifir));
        longClickGesture(driver, driver.findElement(bes));
        longClickGesture(driver, driver.findElement(uc));
        longClickGesture(driver, driver.findElement(sifir));
        longClickGesture(driver, driver.findElement(dort));
        longClickGesture(driver, driver.findElement(sekiz));
        longClickGesture(driver, driver.findElement(alti));
        longClickGesture(driver, driver.findElement(bir));
        longClickGesture(driver, driver.findElement(iki));
        longClickGesture(driver, driver.findElement(yedi));
        longClickGesture(driver, driver.findElement(bes));
        longClickGesture(driver, driver.findElement(ara));








    }
}
