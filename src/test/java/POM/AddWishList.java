package POM;

import element.TakeSnapShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddWishList {
    By wishList = By.cssSelector("body.catalog-category-view.categorypath-tv-html.category-tv:nth-child(2) div.wrapper:nth-child(1) div.page:nth-child(2) div.main-container.col3-layout div.main div.col-wrapper div.col-main div.category-products ul.products-grid.products-grid--max-4-col.first.last.odd:nth-child(2) li.item.last:nth-child(1) div.product-info div.actions ul.add-to-links li:nth-child(1) > a.link-wishlist");
    By wishListSuccessMessage = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/span[1]");
    By wishListLink = By.xpath("//span[contains(text(),'Wishlist')]");
    By wishListShareButton = By.cssSelector("button[title='Share Wishlist']");
    By wishListShareSuccessMessage = By.xpath("//span[contains(text(),'Your Wishlist has been shared.')]");
    By wishListShareEmail = By.xpath("//textarea[@id='email_address']");
    By wishListShareMessage = By.xpath("//textarea[@id='message']");
    By wishListShareSubmitButton = By.xpath("//button[@title='Share Wishlist']");
    By wishListShareCloseButton = By.xpath("//button[@title='Close Window']");
    By tvTab = By.xpath("//a[contains(text(),'TV')]");
    String pathScreenshot = "src/test/java/testEcommerce/TestCase5.2.png";
    WebDriver driver;

    public AddWishList(WebDriver driver) {
        this.driver = driver;
    }

    //exits browser
    public void quit() {
        driver.quit();
    }

    // take screenshot
    public void takeSnapShot(String path) throws Exception {
        TakeSnapShot.takeSnapShot(driver, path);
    }

    public void clickTvTab() {
        driver.findElement(tvTab).click();
    }

    public void clickWishList() {
        driver.findElement(wishList).click();
    }

    public void clickWishListLink() {
        driver.findElement(wishListLink).click();
    }

    public void clickWishListShareButton() {
        driver.findElement(wishListShareButton).click();
    }

    public void inputWishListShareEmail(String email) {
        driver.findElement(wishListShareEmail).sendKeys(email);
    }


    public void inputWishListShareMessage(String message) {
        driver.findElement(wishListShareMessage).sendKeys(message);
    }

    public void clickWishListShareSubmitButton() {
        driver.findElement(wishListShareSubmitButton).click();
    }

    public void clickWishListShareCloseButton() {
        driver.findElement(wishListShareCloseButton).click();
    }

    public String getWishListSuccessMessage() {
        return driver.findElement(wishListSuccessMessage).getText();
    }

    public String getWishListShareSuccessMessage() {
        return driver.findElement(wishListShareSuccessMessage).getText();
    }

    public String getWishListShareEmail() {
        return driver.findElement(wishListShareEmail).getAttribute("value");
    }

    public String getWishListShareMessage() {
        return driver.findElement(wishListShareMessage).getAttribute("value");
    }

    // run test case
    public void wishList(String email, String message) throws Exception {
        clickTvTab();
        clickWishList();
        takeSnapShot(pathScreenshot);
        clickWishListLink();
        clickWishListShareButton();
        inputWishListShareEmail(email);
        inputWishListShareMessage(message);
        clickWishListShareSubmitButton();
        takeSnapShot(pathScreenshot);
        System.out.println("Success message: " + getWishListShareSuccessMessage());
        Assert.assertEquals(getWishListShareSuccessMessage(), "Your Wishlist has been shared.");
        takeSnapShot(pathScreenshot);
        quit();
    }




}
