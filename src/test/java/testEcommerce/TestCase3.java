package testEcommerce;

import driver.driverFactory;
import element.TakeSnapShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Test
public class TestCase3 {
    public static void testCase3() {
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            driver.get("http://live.techpanda.org/");
            By mobileTab = By.xpath("//a[contains(text(),'Mobile')]");
            WebElement clickMobileTab = driver.findElement(mobileTab);
            Actions actions = new Actions(driver);
            actions.click(clickMobileTab).perform();
            By sonyXperiaCartButton = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[2]/div[1]/div[3]/button[1]");
            WebElement clickSonyXperiaAddToCart = driver.findElement(sonyXperiaCartButton);
            // write test case for check sony xperia price is $100 with
            clickSonyXperiaAddToCart.click();
            //wait until change path
            By QTInput = By.xpath("//tbody/tr[1]/td[4]/input[1]");
            WebElement inputQT = driver.findElement(QTInput);
            inputQT.clear();
            inputQT.sendKeys("1000");
            WebDriverWait waitUpdate = new WebDriverWait(driver, Duration.ofSeconds(1));
            waitUpdate.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[4]/button[1]")));
            By updateButton = By.xpath("//tbody/tr[1]/td[4]/button[1]");
            WebElement clickUpdateButton = driver.findElement(updateButton);
            clickUpdateButton.click();
            By errorMessage = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/span[1]");
            WebElement errorMessageElem = driver.findElement(errorMessage);
            System.out.println("Error message: " + errorMessageElem.getText());
            Assert.assertEquals(errorMessageElem.getText(), "The requested quantity for \"Sony Xperia\" is not available.");
            WebElement emptyCartButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/table[1]/tfoot[1]/tr[1]/td[1]/button[2]"));
            emptyCartButton.click();
            System.out.println("Empty cart message: " + driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]")).getText());
            Assert.assertEquals(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]")).getText(), "SHOPPING CART IS EMPTY");
            TakeSnapShot.takeSnapShot(driver, "src/test/java/testEcommerce/TestCase3.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
