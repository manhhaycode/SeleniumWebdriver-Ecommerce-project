package testEcommerce;

import POM.PurchaseProduct;
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

import java.time.Duration;

public class TC06 {
  @Test
  public void testTC06() {

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

    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
      // Step 1 - 7
      PurchaseProduct purchaseProduct = new PurchaseProduct(driver, email, password);
      purchaseProduct.action();

      // Step 8
      WebElement shippingCost = driver.findElement(By.cssSelector(".a-right .price"));
      System.out.println("Shipping cost: " + shippingCost.getText());

      // Step 9
      driver.findElement(By.cssSelector("#s_method_flatrate_flatrate")).click();
      driver.findElement(By.cssSelector(".button[title='Update Total']")).click();

      // Step 10
      WebElement total = driver.findElement(By.cssSelector(".a-right .price"));
      System.out.println("Total: " + total.getText());

      // Step 11
      driver.findElement(By.cssSelector(".button[title='Proceed to Checkout']")).click();

       //Step 12a
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

      // Step 12b
      // Click pop-up open
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#checkout-step-shipping"))));

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
//      Select selectShippingAddress = new Select(shippingAddress);
//      selectShippingAddress.selectByVisibleText("New Address");

      CheckoutPage shippingInfo = new CheckoutPage(driver, "shipping");
      shippingInfo.inputFirstName(firstName);
      shippingInfo.inputMiddleName(middleName);
      shippingInfo.inputLastName(lastName);
      shippingInfo.inputAddress(address);
      shippingInfo.inputCity(city);
      shippingInfo.inputState(state);
      shippingInfo.inputZip(zip);
      shippingInfo.inputCountry(country);
      shippingInfo.inputTelephone(telephone);

      driver.findElement(By.cssSelector("#shipping-buttons-container .button")).click();

      // Step 13
      // Wait for the page to load
      wait.until(ExpectedConditions
          .visibilityOf(driver.findElement(By.cssSelector("#checkout-step-shipping_method"))));

      driver.findElement(By.cssSelector("#shipping-method-buttons-container button")).click();

      // Step 14
      // Wait for the page to load
      wait.until(ExpectedConditions
          .visibilityOf(driver.findElement(By.cssSelector("#checkout-step-payment"))));
      driver.findElement(By.cssSelector("#checkout-step-payment #p_method_checkmo")).click();
      driver.findElement(By.cssSelector("#payment-buttons-container .button")).click();

      // Step 15
      // Wait for the page to load
      wait.until(ExpectedConditions
          .visibilityOf(driver.findElement(By.cssSelector("#checkout-step-review"))));
      driver.findElement(By.cssSelector("#checkout-step-review #review-buttons-container .button")).click();

      // Step 16
      wait.until(ExpectedConditions.urlContains("success"));

      WebElement orderNumber = driver
          .findElement(By.cssSelector(".sub-title ~ p > a"));
      System.out.println("Order number: " + orderNumber.getText());

      // screenshot the result
      TakeSnapShot.takeSnapShot(driver, "src/test/java/testEcommerce/TC06.png");
      System.out.println("Test case TC06 is passed");
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail("Test case TC06 is failed:" + e.getMessage());
    }

    driver.quit();
  }

}
