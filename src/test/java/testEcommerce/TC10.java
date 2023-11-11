package testEcommerce;

import driver.driverFactory;
import element.TakeSnapShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class TC10 {
    public static void testCase10() {
        WebDriver driver = driverFactory.getChromeDriver();
        String id = "user01";
        String pass = "guru99com";
        By username = By.cssSelector("#username");
        By password = By.cssSelector("#login");
        By login = By.cssSelector("div.login-container div.login-box form:nth-child(1) div.login-form div.form-buttons:nth-child(7) > input.form-button");
        By salesMenuLink = By.xpath("//body/div[1]/div[1]/div[3]/ul[1]/li[1]/a[1]");
        By closeWarning = By.xpath("/html[1]/body[1]/div[1]/div[5]/div[1]/a[1]");
        By orderMenuLink = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/ul[1]/li[1]/ul[1]/li[1]/a[1]");
        By orderId = By.cssSelector("#sales_order_grid_filter_real_order_id");
        By fromInput = By.xpath("/html[1]/body[1]/div[1]/div[4]/div[1]/div[3]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[2]/th[3]/div[1]/div[1]/input[1]");
        By toInput = By.xpath("/html[1]/body[1]/div[1]/div[4]/div[1]/div[3]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[2]/th[3]/div[1]/div[2]/input[1]");
        By searchButton = By.xpath("/html[1]/body[1]/div[1]/div[4]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/button[2]");
        driver.get("http://live.techpanda.org/index.php/backendlogin");

        try {
            WebElement inputUsername = driver.findElement(username);
            inputUsername.sendKeys(id);
            WebElement inputPassword = driver.findElement(password);
            inputPassword.sendKeys(pass);
            WebElement clickLogin = driver.findElement(login);
            clickLogin.click();
            Thread.sleep(4000);
            WebElement clickCloseWarning = driver.findElement(closeWarning);
            clickCloseWarning.click();
            WebElement clickSalesMenuLink = driver.findElement(salesMenuLink);
            clickSalesMenuLink.click();
            WebElement clickOrderMenuLink = driver.findElement(orderMenuLink);
            clickOrderMenuLink.click();
            WebElement inputOrderId = driver.findElement(orderId);
            inputOrderId.sendKeys("100021114");
            WebElement inputFrom = driver.findElement(fromInput);
            inputFrom.sendKeys("11/1/2023");
            WebElement inputTo = driver.findElement(toInput);
            inputTo.sendKeys("11/8/2023");
            WebElement clickSearchButton = driver.findElement(searchButton);
            clickSearchButton.click();
            TakeSnapShot.takeSnapShot(driver, "src/test/java/testEcommerce/TestCase10.png");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
