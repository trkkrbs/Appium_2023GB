package techproed.d13practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.ChromeBrowserBaseTest;

public class P09_MobilWebUygulama_KitapYurdu extends ChromeBrowserBaseTest {

    /*
    Mobil Web Uygulamasi yapabilmemiz icin;
    Emulatorden Chrome uygulamasinda kitapyurdu aramasi yapip arattiktan sonra,
    Bilgisayarinizdan yeni bir chrome sekmesi acip,
    chrome://inspect/ linkine gidip,
    Ekrana gelen cihazin altindaki inspect linkine tikliyoruz.
    Buradan locate'leri alip islemler yapabiliyoruz.
    Not: Inspector sadece Mobile Native Uygulamalarda calisiyor. Web uygulamalarinda inspector ile locate alamayiz.
     */

    @Test
    public void testRegister() {
        //URL
        driver.get("https://www.kitapyurdu.com/");


        //Çerez
        WebElement cookiescriptAccept = driver.findElement(By.id("cookiescript_accept"));
        visibleWait(driver, cookiescriptAccept, 15);
        cookiescriptAccept.click();

        //Giriş
        driver.findElement(By.xpath("//a[@href=\"index.php?route=account/account\"]")).click();

        // Üye Ol
        driver.findElement(By.partialLinkText("Ücretsiz Üye Ol")).click();

        // Ad Kutusu
        driver.findElement(By.id("firstname")).sendKeys("Ayşe");

        // Soyad Kutusu
        driver.findElement(By.id("lastname")).sendKeys("Ekinci");

        // Eposta Kutusu
        driver.findElement(By.id("email")).sendKeys("ayseekinci1@godzilla.com");

        // Şifre Kutusu
        driver.findElement(By.id("password")).sendKeys("12345678");

        // Şifre Tekrarı Kutusu
        driver.findElement(By.id("confirm")).sendKeys("12345678");
        driver.hideKeyboard();

        // Kontrol Kutusu
        driver.findElement(By.id("form-check-input")).click();

        // Üye Ol Butonu
        driver.executeScript("arguments[0].click();", driver.findElement(By.id("register-button")));

        // Doğrulama
        Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Hesabınız Oluşturuldu!']")).getText(), "Hesabınız Oluşturuldu!");

    }
}
