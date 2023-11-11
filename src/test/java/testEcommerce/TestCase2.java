package testEcommerce;

import driver.driverFactory;
import element.TakeSnapShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class TestCase2 {
    public static void testCase2() {
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            driver.get("http://live.techpanda.org/");
            By mobileTab = By.xpath("//a[contains(text(),'Mobile')]");
            WebElement clickMobileTab = driver.findElement(mobileTab);
            Actions actions = new Actions(driver);
            actions.click(clickMobileTab).perform();
            By sonyXperiaPrice = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[3]/a[1]/img[1]");
            WebElement clickSonyXperiaProduct = driver.findElement(sonyXperiaPrice);
            // write test case for check sony xperia price is $100 with ExpectedConditions
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.textToBePresentInElement(clickSonyXperiaProduct, "$100.00"));
            TakeSnapShot.takeSnapShot(driver, "src/test/java/testEcommerce/TestCase2.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
