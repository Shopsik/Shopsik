import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstTest extends BaseTest {

    @Test
    public void zipTest() {
        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("1234");
        browser.findElement(By.xpath("//*[@value='Continue']")).click();
        String errorMsg = browser.findElement(By.cssSelector(".error_message")).getText();
        assertEquals(errorMsg, "Oops, error on page. ZIP code should have 5 digits", "Zip code");
    }

    @Test
    public void zipTest2() {
        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("12345");
        browser.findElement(By.xpath("//*[@value='Continue']")).click();
        boolean RegButisPresent = browser.findElement(By.xpath("//*[@value='Register']")).isDisplayed();
        assertTrue(RegButisPresent);
    }
}