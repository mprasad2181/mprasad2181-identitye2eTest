package com.prasad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
    public boolean isVrmElementVisibleAfterStartButtonClick() {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement webElement = getDriver().findElement(By.linkText("Start now"));
        webElement.click();
        WebElement vrmElement = (new WebDriverWait(getDriver(), 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("Vrm")));

       return vrmElement.isDisplayed();
    }

}
