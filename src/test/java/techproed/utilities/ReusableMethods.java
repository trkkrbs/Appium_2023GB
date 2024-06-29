package techproed.utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
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


    public void scrollToTextAndAddToCart(AndroidDriver driver, String productName) {
        try {
            System.out.println("Scrolling to product: " + productName);

            // Scroll to the element containing the product name
            AppiumBy.ByAndroidUIAutomator productElement = new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + productName + "\"))"
            );
            WebElement product = driver.findElement(productElement);

            System.out.println("Found product: " + productName);

            // Find the parent element using the product element's ancestor axis
            String parentXpath = "//android.widget.TextView[@text='" + productName + "']/ancestor::android.widget.RelativeLayout";
            System.out.println("Parent XPath: " + parentXpath);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement productContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath(parentXpath)
            ));

            System.out.println("Found product container for: " + productName);

            // Find the "ADD TO CART" button within the parent element dynamically
            String addToCartButtonXpath = ".//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']";
            System.out.println("Add to Cart Button XPath: " + addToCartButtonXpath);

            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                    productContainer.findElement(AppiumBy.xpath(addToCartButtonXpath))
            ));

            System.out.println("Found 'ADD TO CART' button for product: " + productName);

            // Click the "ADD TO CART" button
            if (addToCartButton.isDisplayed() && addToCartButton.isEnabled()) {
                addToCartButton.click();
                System.out.println("Clicked 'ADD TO CART' button for product: " + productName);
            } else {
                System.out.println("'ADD TO CART' button is not clickable for product: " + productName);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found for product: " + productName + ". Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Could not click 'ADD TO CART' for product: " + productName + ". Error: " + e.getMessage());
        }
    }

    //Visible Wait
    public static void visibleWait(AndroidDriver driver, WebElement element, int sayi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

