package testEcommerce;

import POM.AddWishList;
import POM.RegisterPage;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class TestCase5 {
    public static void testCase5() {
        // implement Register page test case
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            driver.get("http://live.techpanda.org/");
            RegisterPage registerPage = new RegisterPage(driver);
            AddWishList wishList = new AddWishList(driver);
            registerPage.register("Manh", "Nguyen", "7M@gmail.com", "12345678", "12345678");
            wishList.wishList("manhnvse173470@fpt.edu.vn", "LG LCD");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
