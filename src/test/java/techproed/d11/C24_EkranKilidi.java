package techproed.d11;

import org.testng.annotations.Test;
import techproed.basetest.DeviceBaseTest;

import java.time.Duration;

// github.com/appium/appium-uiautomator2-driver?£device-locking

public class C24_EkranKilidi extends DeviceBaseTest {

    @Test
    public void testLockDevice() {
        driver.lockDevice(Duration.ofSeconds(3));
        bekle(3);
    }

    @Test
    public void testUnlockDevice() {
        driver.lockDevice();
        bekle(3);
        driver.unlockDevice();
        bekle(3);
    }

    @Test
    public void testIsDeviceLocked() {
        System.out.println(driver.isDeviceLocked()); //false
        driver.lockDevice();
        bekle(3);
        System.out.println(driver.isDeviceLocked()); //true
        driver.unlockDevice();
        bekle(3);
        System.out.println(driver.isDeviceLocked()); //false
    }
}
