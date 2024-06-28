package techproed.utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class ReusableMethods {

    public void bekle(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            System.out.println("Bekleme yapilamadi");
            throw new RuntimeException(e);
        }
    }
    public void clickGesture(AndroidDriver driver, WebElement element) {
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public void clickGesture(AndroidDriver driver, int x, int y) {
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));
    }

    public void doubleClickGesture(AndroidDriver driver, WebElement element) {
        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public void doubleClickGesture(AndroidDriver driver, int x, int y) {
        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));
    }

    public void longClickGesture(AndroidDriver driver, WebElement element) {
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public void longClickGesture(AndroidDriver driver, WebElement element, int milisecond) {
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", milisecond
        ));
    }

    public void longClickGesture(AndroidDriver driver, int x, int y) {
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));
    }

    public void longClickGesture(AndroidDriver driver, int x, int y, int milisecond) {
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", x,
                "y", y,
                "duration", milisecond
        ));
    }

    public void dragGesture(AndroidDriver driver, WebElement element, int endX, int endY, int speed) {
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", endX,
                "endY", endY,
                "speed", speed // Zorunlu degil. Eklenmediginde 2500 * displayDensity hizinda tasiyor.
        ));
    }

    public void dragGesture(AndroidDriver driver,int startX, int startY, int endX, int endY, int speed) {
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX", startX,
                "startY", startY,
                "endX", endX,
                "endY", endY,
                "speed", speed // Zorunlu degil. Eklenmediginde 2500 * displayDensity hizinda tasiyor.
        ));
    }

    public void swipeGesture(AndroidDriver driver, WebElement element, String direction, double percent, int speed) {
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent,
                "speed", speed
        ));
    }

    public void scrollGesture(AndroidDriver driver, WebElement element, String direction, double percent, int speed) {
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent,
                "speed", speed
        ));
    }

//    public void scrollTo(String text){
//        AppiumBy.ByAndroidUIAutomator permissionElement = new  AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ text +"\"))");
//
//        driver.findElement(permissionElement);
//    }

    public void scrollToText(AndroidDriver driver, String text ) {
        try {
            AppiumBy.ByAndroidUIAutomator permissionElement = new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))");
            driver.findElement(permissionElement);
        } catch (Exception e) {
            System.out.println("Element not found: " + e.getMessage());
        }
    }

    public void scrollToTextAndCLick(AndroidDriver driver, String text ) {
        try {
            AppiumBy.ByAndroidUIAutomator permissionElement = new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))");
            WebElement element = driver.findElement(permissionElement);
            element.click();
        } catch (Exception e) {
            System.out.println("Element not found: " + e.getMessage());
        }
    }

    public static void productNameKnownAddToCart(AndroidDriver driver, String productName) {
        try {
            // Scroll to the product name
            AppiumBy.ByAndroidUIAutomator productElement = new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + productName + "\"))");
            WebElement product = driver.findElement(productElement);

            // Find the parent element of the product name
            WebElement productContainer = product.findElement(AppiumBy.xpath(".."));

            // Find the "Add to Cart" button within the product container
            WebElement addToCartButton = productContainer.findElement(AppiumBy.xpath(".//android.widget.Button[contains(@text, 'Add to Cart')]"));

            // Click the "Add to Cart" button
            addToCartButton.click();
        } catch (Exception e) {
            System.out.println("Element not found or could not click 'Add to Cart': " + e.getMessage());
        }
    }

    public void scrollToTextAndAddToCart(AndroidDriver driver, String productName, String parentXpath) {
        try {
            // Ürün adını içeren öğeye kaydırma işlemi yap
            AppiumBy.ByAndroidUIAutomator productElement = new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + productName + "\"))"
            );
            WebElement product = driver.findElement(productElement);

            // Ürün öğesinin ebeveyn öğesini verilen XPath ile bul
            WebElement productContainer = product.findElement(AppiumBy.xpath(parentXpath));
            bekle(2);
            // Ebeveyn öğesi içindeki "ADD TO CART" butonunu bul
            //WebElement addToCartButton = productContainer.findElement(AppiumBy.xpath(".//android.widget.Button[@text='ADD TO CART']"));
            WebElement addToCartButton = productContainer.findElement(AppiumBy.xpath(".//android.widget.TextView[@text='ADD TO CART']"));
//            (//android.widget.TextView[@text="ADD TO CART"])


            // "ADD TO CART" butonuna tıkla
            addToCartButton.click();
        } catch (Exception e) {
            System.out.println("Element not found or could not click 'ADD TO CART': " + e.getMessage());
        }
    }
}

