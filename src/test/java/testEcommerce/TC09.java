package testEcommerce;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TC09 {


    public static void testCase9() {
        WebDriver driver = driverFactory.getChromeDriver();
        By mobileTab = By.xpath("//a[contains(text(),'Mobile')]");
        By buttonCartIphone = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[3]/button[1]");
        By couponInput = By.cssSelector("#coupon_code");
        By applyButton = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]/span[1]");
        By subTotal = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]");
        By grandTotal = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tfoot[1]/tr[1]/td[2]/strong[1]/span[1]");
        By discount = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/span[1]");
        driver.get("http://live.techpanda.org/");


        try {
            Thread.sleep(2000);
            WebElement clickMobile = driver.findElement(mobileTab);
            clickMobile.click();
            WebElement clickCartIphone = driver.findElement(buttonCartIphone);
            clickCartIphone.click();
            WebElement inputCoupon = driver.findElement(couponInput);
            inputCoupon.sendKeys("GURU50");
            WebElement clickApplyButton = driver.findElement(applyButton);
            clickApplyButton.click();
            WebElement getSubTotal = driver.findElement(subTotal);
            double subTotalValue = Double.parseDouble(getSubTotal.getText().replace("$", ""));
            WebElement getDiscount = driver.findElement(discount);
            WebElement getGrandTotal = driver.findElement(grandTotal);
            double grandTotalValue = Double.parseDouble(getGrandTotal.getText().replace("$", ""));
            Double discountValue = Double.parseDouble(getDiscount.getText().replace("$", ""));
            Assert.assertEquals(grandTotalValue, subTotalValue-(subTotalValue * 0.05));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
