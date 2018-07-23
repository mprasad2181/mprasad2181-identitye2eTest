package test.com.prasad;

import com.prasad.SearchVehiclePage;
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

   private SearchVehiclePage homePage;

    @BeforeTest
    public void launchBrowser() {
        System.setProperty(Constants.GECKO_KEY, Constants.GECKO_DRIVER_LOCATION);
        WebDriver driver= new FirefoxDriver();
        homePage= new SearchVehiclePage(driver);
        homePage.open();
    }

    @Test
    public void canGoToHomePage() {
        String title = homePage.getTitle();
        Assert.assertEquals(title, Constants.TITLE);
    }
    @Test
    public void  isVrmElementVisibleAfterStartButtonClick() {
        boolean vrmElementVisible = homePage.isVrmElementVisibleAfterStartButtonClick();
        Assert.assertTrue(vrmElementVisible);
    }


}
