package techproed.d13practice;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
        scrollToTextAndAddToCart(driver, "Converse All Star");

        Thread.sleep(5000);

        //scrollToText(driver, "LeBron Soldier 12 ");
        //driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).click();
        scrollToTextAndAddToCart(driver, "LeBron Soldier 12 ");
        // ilk urun secilip adi da degistigi icin list ve dolayisiyla index'e gerek kalmadi.
        // Her halukarda text tiklanma islemi sonrasinda 1.urunun xpath'e gore locate'i degiseceginden ikinci urunun locate'i de ayni xpath locate olacaktir.

        bekle(5);
        // Sepete gidiyoruz...
        WebElement cart = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
        cart.click();

        bekle(2);

        // Fiyat dogruluyoruz...
        List<WebElement> products = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
        Assert.assertEquals(products.size(), 2);

        double total = 0;
        for (int i = 0; i < products.size(); i++) {
            String priceText = products.get(i).getText(); //$160.97 --> $120.0
            double price = Double.parseDouble(priceText.substring(1)); //160.97 --> 120.0
            total += price;
        }

//        for (WebElement w:products){
//            String priceText = w.getText();
//            double price = Double.parseDouble(priceText.substring(1));
//            total += price;
//        }

        double totalAmount = Double.parseDouble(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));

        Assert.assertEquals(total, totalAmount);


        WebElement checkBox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        checkBox.click();

        WebElement visitButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed"));
        visitButton.click();

        bekle(3);

        //Hibrit Uygulama
        //Sadece Web context'inin degerini alabilmek icin bu kodu yazmaya ihtiyacim var.
/*        Set<String> contextHandles = driver.getContextHandles();
        for (String contextName: contextHandles){
            System.out.println(contextName);
        }*/

        //Emulatorde websayfasina geldigimizde yukaridaki method ile console'dan context degerini almak yerine,
        //Inspector'de ust kisimda yer alan Commands'a tiklayip acilan menuden Context ve sonrasinda getContexts butonuna tiklayarak,
        // [
        //  "NATIVE_APP",
        //  "WEBVIEW_com.androidsample.generalstore"
        //]
        //Context degerlerini gorup Web icin olan context degerini alabiliriz.

        driver.context("WEBVIEW_com.androidsample.generalstore"); //Driver'imizi web context degerine geciriyoruz.

        //Arama motoru
        //Native uygulamadan Web uygulamasina gectigimizde once yukaridaki sekilde web context degerine gecis yapmaliyiz.
        //Sonrasinda ise locatelerimizi alabilmek icin emulatorumuzden calistigimiz uygulamaya (General Store) girip,
        //Uygulamada webpage sayfasina geldikten sonra,
        //chrome://inspect/   ==> Bilgisayardan farkli bir chrome sayfasi acarak url'e soldaki linki copy paste yapalim.
        //Ekrana gelen cihazimizin altindaki inspect linkine tikliyoruz.
        //Boylece inspector'e benzeyen yeni bir arayuz gozukecek burada locate islemlerimizi rahatlikla yapabiliriz.

        driver.findElement(By.name("q")).sendKeys("Temel Reis", Keys.ENTER);

        //Native Uygulamaya Geri Gecis
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); //Once native uygulamaya geciyoruz.
        driver.context("NATIVE_APP"); //Sonra driverimizin context degerini degistiriyoruz.

        //Baslik Dogrulamasi
        String baslik = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals(baslik, "General Store");

        bekle(5);



    }
}

