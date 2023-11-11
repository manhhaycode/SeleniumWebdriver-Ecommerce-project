package testEcommerce;

import driver.driverFactory;
import element.TakeSnapShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import POM.CheckoutPage;
import POM.LoginPage;

import java.time.Duration;

public class TC08 {
  @Test
  public void testTC08() {

    WebDriver driver = driverFactory.getChromeDriver();
    String firstName = "Manh";
    String middleName = "Viet";
    String lastName = "Nguyen";
    String email = "7M@gmail.com";
    String password = "12345678";
    String address = "123 Phan Van Tri";
    String city = "Ho Chi Minh City";
    String state = "Georgia";
    String zip = "123456";
    String country = "United States";
    String telephone = "1234567890";
    String qty = "13";

    try {
      // Step 1
      driver.get("http://live.techpanda.org/");
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("h2"))));

      // Step 2
      driver.findElement(By.cssSelector(".links:nth-child(4) .first > a")).click();

      // Step 3
      LoginPage loginPage = new LoginPage(driver);
      loginPage.inputEmail(email);
      loginPage.inputPassword(password);

      driver.findElement(By.cssSelector("#send2")).click();

      // Step 4
      driver.findElement(By.cssSelector("#my-orders-table .first:first-child .link-reorder")).click();
      String grandTotalSelector = "#shopping-cart-totals-table tfoot .a-right:nth-child(2) .price";
      String grandTotal = driver.findElement(By.cssSelector(grandTotalSelector)).getText();

      WebElement qtyInput = driver
          .findElement(By.cssSelector("#shopping-cart-table tbody .first:first-child .product-cart-actions .qty"));
      qtyInput.clear();
      qtyInput.sendKeys(qty);
      driver
          .findElement(
              By.cssSelector("#shopping-cart-table tbody .first:first-child .product-cart-actions .btn-update"))
          .click();

      // Step 5
      String newGrandTotal = driver.findElement(By.cssSelector(grandTotalSelector)).getText();

      Assert.assertNotEquals(grandTotal, newGrandTotal);

      System.out.println("Grand Total: " + grandTotal);

      // Step 6
      driver.findElement(By.cssSelector(".button[title='Proceed to Checkout']")).click();

      // Step 7
      By billing = By.cssSelector("#billing-address-select");
      WebElement billingAddress = null;
      try {
        billingAddress = driver.findElement(billing);
      } catch (Exception e) {
        System.out.println("Billing address is not displayed");
      }

      if(billingAddress!=null) {
        Select selectBillingAddress = new Select(billingAddress);
        selectBillingAddress.selectByVisibleText("New Address");
      }

      CheckoutPage billingInfo = new CheckoutPage(driver, "billing");
      billingInfo.inputFirstName(firstName);
      billingInfo.inputMiddleName(middleName);
      billingInfo.inputLastName(lastName);
      billingInfo.inputAddress(address);
      billingInfo.inputCity(city);
      billingInfo.inputCountry(country);
      billingInfo.inputState(state);
      billingInfo.inputZip(zip);
      billingInfo.inputTelephone(telephone);

      driver.findElement(By.cssSelector("#billing\\:use_for_shipping_no")).click();
      driver.findElement(By.cssSelector("#billing-buttons-container .button")).click();

      wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#shipping-address-select"))));

      WebElement shippingAddress = null;
      try {
        shippingAddress = driver.findElement(By.cssSelector("#shipping-address-select"));
      } catch (Exception e) {
        System.out.println("Shipping address is not displayed");
      }
      if(shippingAddress!=null) {
        Select selectShippingAddress = new Select(shippingAddress);
        selectShippingAddress.selectByVisibleText("New Address");
      }

      CheckoutPage shippingInfo = new CheckoutPage(driver, "shipping");
      shippingInfo.inputFirstName(firstName);
      shippingInfo.inputMiddleName(middleName);
      shippingInfo.inputLastName(lastName);
      shippingInfo.inputAddress(address);
      shippingInfo.inputCity(city);
      shippingInfo.inputCountry(country);
      shippingInfo.inputState(state);
      shippingInfo.inputZip(zip);
      shippingInfo.inputTelephone(telephone);

      driver.findElement(By.cssSelector("#shipping-buttons-container .button")).click();

      wait.until(ExpectedConditions
          .visibilityOf(driver.findElement(By.cssSelector("#checkout-step-shipping_method"))));

      driver.findElement(By.cssSelector("#shipping-method-buttons-container button")).click();

      wait.until(ExpectedConditions
          .visibilityOf(driver.findElement(By.cssSelector("#checkout-step-payment"))));
      driver.findElement(By.cssSelector("#checkout-step-payment #p_method_checkmo")).click();
      driver.findElement(By.cssSelector("#payment-buttons-container .button")).click();

      wait.until(ExpectedConditions
          .visibilityOf(driver.findElement(By.cssSelector("#checkout-step-review"))));
      driver.findElement(By.cssSelector("#checkout-step-review #review-buttons-container .button")).click();

      // Step 8
      // wait for the page navigating
      wait.until(ExpectedConditions.urlContains("success"));

      WebElement orderNumber = driver
          .findElement(By.cssSelector(".sub-title ~ p > a"));
      System.out.println("Order number: " + orderNumber.getText());

      // screenshot the result
      TakeSnapShot.takeSnapShot(driver, "src/test/java/testEcommerce/TestCase8.png");
      System.out.println("Test case TC08 is passed");
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail("Test case TC08 is failed:" + e.getMessage());
    }

    driver.quit();
  }

}
