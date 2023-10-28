package POM;

import element.TakeSnapShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage {
    By firstName = By.cssSelector("#firstname");
    By lastName = By.cssSelector("#lastname");
    By email = By.cssSelector("#email_address");
    By password = By.cssSelector("#password");
    By confirmPassword = By.cssSelector("#confirmation");
    By registerButton = By.cssSelector("button[title='Register']");
    By successMessage = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/span[1]");

    String pathScreenshot = "src/test/java/testEcommerce/TestCase5.png";

    WebDriver driver;


    public RegisterPage(WebDriver driver) {
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

    public void clickAccountLink() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/div[2]/div[1]/a[1]")).click();
    }

    //click on register link
    public void clickRegisterLink() {
        driver.findElement(By.cssSelector("body.cms-index-index.cms-home:nth-child(2) div.wrapper:nth-child(1) div.page:nth-child(2) header.page-header div.page-header-container div.skip-content.skip-active:nth-child(6) div.links ul:nth-child(1) li:nth-child(5) > a:nth-child(1)")).click();
    }

    public void inputFirstName(String firstName) {
        driver.findElement(this.firstName).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        driver.findElement(this.lastName).sendKeys(lastName);
    }

    public void inputEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    public void inputPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void inputConfirmPassword(String confirmPassword) {
        driver.findElement(this.confirmPassword).sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        driver.findElement(this.registerButton).click();
    }

    public String getSuccessMessageD() {
        return driver.findElement(this.successMessage).getText();
    }


    // run test case
    public void register(String firstName, String lastName, String email, String password, String confirmPassword) throws Exception {
        clickAccountLink();
        clickRegisterLink();
        inputFirstName(firstName);
        inputLastName(lastName);
        inputEmail(email);
        inputPassword(password);
        inputConfirmPassword(confirmPassword);
        clickRegisterButton();
        System.out.println("Success message: " + getSuccessMessageD());
        takeSnapShot(pathScreenshot);
        Assert.assertEquals(getSuccessMessageD(), "Thank you for registering with Main Website Store.");
    }

    public By getFirstName() {
        return firstName;
    }

    public By getLastName() {
        return lastName;
    }

    public By getEmail() {
        return email;
    }

    public By getPassword() {
        return password;
    }

    public By getConfirmPassword() {
        return confirmPassword;
    }

    public By getRegisterButton() {
        return registerButton;
    }

    public By getSuccessMessage() {
        return successMessage;
    }

    public void setFirstName(By firstName) {
        this.firstName = firstName;
    }

    public void setLastName(By lastName) {
        this.lastName = lastName;
    }

    public void setEmail(By email) {
        this.email = email;
    }

    public void setPassword(By password) {
        this.password = password;
    }

    public void setConfirmPassword(By confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setRegisterButton(By registerButton) {
        this.registerButton = registerButton;
    }

    public void setSuccessMessage(By successMessage) {
        this.successMessage = successMessage;
    }


}
