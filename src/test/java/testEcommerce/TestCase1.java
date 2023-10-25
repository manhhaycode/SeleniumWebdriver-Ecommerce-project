package testEcommerce;

import driver.driverFactory;
import element.ElementController;
import element.TakeSnapShot;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.time.Duration;

@Test
public class TestCase1 {
    public static void testCase1() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");
        By title = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]");
        By mobileTab = By.xpath("//a[contains(text(),'Mobile')]");
        WebElement clickMobileTab = driver.findElement(mobileTab);
        System.out.println("Is title of the page displayed: " + driver.findElement(title).isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        Actions actions = new Actions(driver);

        try {
            actions.click(clickMobileTab).perform();
            By dropdownSort = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/select[1]");
            WebElement selectDropdownSort = driver.findElement(dropdownSort);
            Select selectOption = new Select(selectDropdownSort);
            selectOption.selectByVisibleText("Name");
            //get three first products name
            By firstProduct = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/div[1]/h2[1]");
            WebElement firstProductName = driver.findElement(firstProduct);
            System.out.println("First product name: " + firstProductName.getText());
            By secondProduct = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[2]/div[1]/h2[1]");
            WebElement secondProductName = driver.findElement(secondProduct);
            System.out.println("Second product name: " + secondProductName.getText());
            By thirdProduct = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[3]/div[1]/h2[1]");
            WebElement thirdProductName = driver.findElement(thirdProduct);
            System.out.println("Third product name: " + thirdProductName.getText());
            TakeSnapShot.takeSnapShot(driver, "src/test/java/testEcommerce/TestCase1.png");
            // write test if first product name is IPHONE so pass use ExpectedConditions
            wait.until(ExpectedConditions.textToBePresentInElement(firstProductName, "IPHONE"));
            wait.until(ExpectedConditions.textToBePresentInElement(secondProductName, "SAMSUNG GALAXY"));
            wait.until(ExpectedConditions.textToBePresentInElement(thirdProductName, "SONY XPERIA"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
