package techproed.d13;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.GeneralStoreBaseTest;

import java.util.List;

public class P08_HibritUygulama_GeneralStore extends GeneralStoreBaseTest {

     /*
    Uygulama: GeneralStore
    GeneralStore uygulamasina gir
    Menuden Angola secenegini sec
    Your Name kutusuna Safinaz yaz
    Gender bolumunden Female secenegini sec
    Let's Shop butonuna tikla
    Urun listesindeki iki urunu sepete ekle
    Sepete gir
    Sepette iki urun oldugunu dogrula
    Urun fiyatlarini topla
    Total Purchase Amount bolumundeki tutarin dogru oldugunu dogrula
    Send me e-mails... kututusunu sec
    Visit to the website.. butonuna tikla
     */

    @Test
    public void testGeneralStore() throws InterruptedException {
        WebElement menu = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
        menu.click();

        //Ulke secimi
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Barbados\"))"));
        //WebElement barbados = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Barbados\"]"));;
        //barbados.click();
        scrollToTextAndCLick(driver, "Barbados");

        // Isim giriyoruz...
        WebElement yourNameBox = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
        yourNameBox.sendKeys("Safinaz");

        // Cinsiyet seciyoruz...
        WebElement femaleCheckbox = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
        femaleCheckbox.click();

        // Butona tiklama yapiyoruz...
        WebElement letsShopButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
        letsShopButton.click();

        //scrollToText(driver,"Converse All Star");
        //driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).get(1).click();
        scrollToTextAndAddToCart(driver, "Converse All Star", "//android.support.v7.widget.RecyclerView[@resource-id=\"com.androidsample.generalstore:id/rvProductList\"]/android.widget.RelativeLayout[2]");

        Thread.sleep(5000);

        //scrollToText(driver, "LeBron Soldier 12 ");
        //driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).click();
        scrollToTextAndAddToCart(driver, "LeBron Soldier 12 ", "//android.support.v7.widget.RecyclerView[@resource-id=\"com.androidsample.generalstore:id/rvProductList\"]/android.widget.RelativeLayout[3]");
        // ilk urun secilip adi da degistigi icin list ve dolayisiyla index'e gerek kalmadi.
        // Her halukarda text tiklanma islemi sonrasinda 1.urunun xpath'e gore locate'i degiseceginden ikinci urunun locate'i de ayni xpath locate olacaktir.

//        // Sepete gidiyoruz...
//        WebElement cart = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
//        cart.click();
//
//        System.out.println(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText());
////        bekle(2);
//
//        // Fiyat dogruluyoruz...
//        List<WebElement> products = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
//        Assert.assertEquals(products.size(), 3);
//
//        double total = 0;
//        for (int i = 0; i < products.size(); i++) {
//            String priceText = products.get(i).getText(); //$160.97 --> $120.0
//            double price = Double.parseDouble(priceText.substring(1)); //160.97 --> 120.0
//            total += price;
//        }
//
////        for (WebElement w:products){
////            String priceText = w.getText();
////            double price = Double.parseDouble(priceText.substring(1));
////            total += price;
////        }
//
//        double totalAmount = Double.parseDouble(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));
//
//        Assert.assertEquals(total, totalAmount);
//
//
//        WebElement checkBox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
//        checkBox.click();
//
//        WebElement visitButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed"));
//        visitButton.click();
//
//        Thread.sleep(5000);
        //

    }
}

