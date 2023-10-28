package testEcommerce;

import driver.driverFactory;
import element.TakeSnapShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Test
public class TestCase4 {
    public static void testCase4() {
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            driver.get("http://live.techpanda.org/");
            By mobileTab = By.xpath("//a[contains(text(),'Mobile')]");
            WebElement clickMobileTab = driver.findElement(mobileTab);
            Actions actions = new Actions(driver);
            actions.click(clickMobileTab).perform();
            WebElement sonyXperiaCompareButton = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[2]/div[1]/div[3]/ul[1]/li[2]/a[1]"));
            sonyXperiaCompareButton.click();
            WebElement iphoneCompareButton = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[3]/div[1]/div[3]/ul[1]/li[2]/a[1]"));
            iphoneCompareButton.click();
            WebElement compareButton = driver.findElement(By.cssSelector("button[title='Compare']"));
            compareButton.click();
            // change to popup window
            List<String> windowIds = new ArrayList<>(driver.getWindowHandles());
            final int SECOND_WINDOW = 1;
            driver.switchTo().window(windowIds.get(SECOND_WINDOW));
            WebElement popupWindow = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/h1[1]"));
            System.out.println("Popup window: " + popupWindow.getText());
            Assert.assertEquals(popupWindow.getText(), "COMPARE PRODUCTS");
            TakeSnapShot.takeSnapShot(driver, "src/test/java/testEcommerce/TestCase4.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
