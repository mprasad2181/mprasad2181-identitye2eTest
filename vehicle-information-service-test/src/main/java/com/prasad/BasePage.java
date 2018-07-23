package com.prasad;


import org.openqa.selenium.WebDriver;

/**
 * BasePage
 * identitye2e
 * Description :
 */

public class BasePage {

    private static final String  url= "https://www.gov.uk/get-vehicle-information-from-dvla";

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void open() {
        driver.get(url);
    }

}
