package techproed.d12;

import org.testng.annotations.Test;
import techproed.basetest.ChromeBrowserBaseTest;

public class C27_MobilWebUygulamaTesti extends ChromeBrowserBaseTest {
    @Test
    public void testBrowser() {
        driver.get("https://www.google.com");

        bekle(2);
    }
}
