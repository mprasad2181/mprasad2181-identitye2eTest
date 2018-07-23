package test.com.prasad;

import com.prasad.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * TestHomePage
 * identitye2e
 * Description :
 */

public class TestHomePage {

   private HomePage homePage;

    @BeforeTest
    public void launchBrowser() {
        System.setProperty(Constants.GECKO_KEY, Constants.GECKO_DRIVER_LOCATION);
        WebDriver driver= new FirefoxDriver();
        homePage= new HomePage(driver);
        homePage.open();
    }

    @Test
    public void canGoToHomePage() {
        String title = homePage.getTitle();
        Assert.assertEquals(title, Constants.TITLE);
    }
}
