package com.prasad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * HomePage
 * identitye2e
 * Description :
 */

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getDriver().getTitle();
    }


}
