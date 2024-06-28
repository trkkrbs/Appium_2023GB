package techproed.d05practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.MyDemoBaseTest;

import java.util.List;

public class P04_MyDemoApp_ColorTest extends MyDemoBaseTest {

        /*
        MyDemoApp uygulamasina gir
        Menuyu ac
        Login ol (bob@example.com, 10203040)
        Login butonuna tikla
        Ilk urunu sec
        Renk olarak mavi sec
        Add To Cart butonuna tikla
        Renk olarak kirmizi sec
        Add To Cart butonuna tikla
        Sepete git
        Listede iki urun oldugunu dogrula
        Listedeki urunlerin mavi ve kirmizi oldugunu dogrula
         */

    @Test
    public void testColor() throws InterruptedException {
        WebElement menu = driver.findElement(AppiumBy.accessibilityId("open menu"));
        menu.click();

        WebElement menuItemLogin = driver.findElement(AppiumBy.accessibilityId("menu item log in"));
        menuItemLogin.click();

        WebElement usernameInputField = driver.findElement(AppiumBy.accessibilityId("Username input field"));
        usernameInputField.click();
        usernameInputField.sendKeys("bob@example.com");

        WebElement passwordInputField = driver.findElement(AppiumBy.accessibilityId("Password input field"));
        passwordInputField.sendKeys("10203040");
        driver.hideKeyboard();
        Thread.sleep(3000);

        WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("Login button"));
        loginButton.click();

        WebElement productTitle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Backpack\")"));
        productTitle.click();

//        WebElement blueCircle = driver.findElement(AppiumBy.accessibilityId("blue circle"));
//        blueCircle.click();
        By blueCircle = AppiumBy.accessibilityId("blue circle"); //Sayfa degistiginde ayni elementi kullanmak istiyorum. StaleElement hatasi almamak icin By ile container icerisine koydum.
        driver.findElement(blueCircle).click();

        WebElement addToCartButton = driver.findElement(AppiumBy.accessibilityId("Add To Cart button"));
        addToCartButton.click();

//        WebElement redCircle = driver.findElement(AppiumBy.accessibilityId("red circle"));
//        redCircle.click();
        By redCircle = AppiumBy.accessibilityId("red circle");
        driver.findElement(redCircle).click();

        addToCartButton.click();

        WebElement cartBadge = driver.findElement(AppiumBy.accessibilityId("cart badge"));
        cartBadge.click();

        List<WebElement> productRow = driver.findElements(AppiumBy.accessibilityId("product row"));
        Assert.assertEquals(productRow.size(), 2);

        WebElement blueCircle2 = driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"product row\"])[1]//android.view.ViewGroup[contains(@content-desc, 'blue circle')]"));


        Assert.assertTrue(blueCircle2.isDisplayed());
        Assert.assertTrue(driver.findElement(redCircle).isDisplayed());
    }
}
