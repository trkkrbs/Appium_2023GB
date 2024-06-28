package techproed.d08practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.KitapyurduBaseTest;
import techproed.basetest.TelefonBaseTest;

import java.util.List;

// Emulatorden telefon uygulamasini ac
// Yeni terminalde adb shell komutununu yaz ve enter'a bas
// Sonra dumpsys window displays | grep -E 'mCurrentFocus' komutunu yaz ve enter'a bas

// UYGULAMA TELEFON
// 1. Kitapyurdu uygulamasina gir.
// 2. Ilgi Gorenler bolumundeki 5.kitaba tikla.
// 3. Kitap adi, Yazar adi ve Yayinevi adi bilgilerini yazdir.
// 4. Kunye basliklarini ve bilgilerini yazdir.

public class P06_KitapYurdu_ScrollSwipeGestures extends KitapyurduBaseTest {

    @Test
    public void testKitapYurdu() throws InterruptedException {
        WebElement swipeElement = driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/recyclerViewList"));
        swipeGesture(driver, swipeElement, "left", 1.0, 1000);

        WebElement besinciKitap = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.mobisoft.kitapyurdu:id/imageViewProduct\"])[2]"));
        clickGesture(driver, besinciKitap);

        List<WebElement> kitapBilgileri = driver.findElements(AppiumBy.xpath("//android.widget.ScrollView[@resource-id=\"com.mobisoft.kitapyurdu:id/productDetailScrollView\"]/android.view.ViewGroup/android.widget.TextView"));
        System.out.println("Kitap Adi = " + kitapBilgileri.get(0).getText());
        System.out.println("Yazar Adi = " + kitapBilgileri.get(1).getText());
        System.out.println("Yayinevi Adi = " + kitapBilgileri.get(2).getText());
        System.out.println("----------------------------------------");

        // https://developer.android.com/reference/androidx/test/uiautomator/UiSelector
        // Elemente scroll
        // driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Künye\"))"));
        // yukaridaki kod developer'in scrollable ozelligi atamadigindan calismadi.

        WebElement scrollElement = driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/productDetailScrollView"));
        scrollGesture(driver, scrollElement, "down", 2.5, 1000);

        List<WebElement> kunyeBasliklari = driver.findElements(AppiumBy.id("com.mobisoft.kitapyurdu:id/textViewAttributeTitle"));
        List<WebElement> kunyeBilgileri = driver.findElements(AppiumBy.id("com.mobisoft.kitapyurdu:id/textViewAttributeName"));

        for (int i = 0; i < kunyeBasliklari.size(); i++) {
            System.out.print(kunyeBasliklari.get(i).getText() + "\t");
            System.out.println(kunyeBilgileri.get(i).getText());

        }


        Thread.sleep(5000);
    }


}
