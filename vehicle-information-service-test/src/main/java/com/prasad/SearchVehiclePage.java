package com.prasad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * HomePage
 * identitye2e
 * Description :
 */

public class SearchVehiclePage extends BasePage {

    public SearchVehiclePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public boolean isVrmElementVisibleAfterStartButtonClick() {
        WebElement webElement = getDriver().findElement(By.linkText("Start now"));
        webElement.click();
        WebElement vrmElement = (new WebDriverWait(getDriver(), 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("Vrm")));

       return vrmElement.isDisplayed();
    }

    public String submitVrmAndGetColor(String registrationNumber) {

        WebElement webElement = getDriver().findElement(By.id("Vrm"));
        webElement.sendKeys(registrationNumber);

        WebElement submitElement = getDriver().findElement(By.className("button"));
        webElement.submit();

        WebElement colorElement = null;
        String color;
        try {
            colorElement = (new WebDriverWait(getDriver(), 30))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/form/div/div/ul/li[3]/span[2]/strong")));
            color =colorElement.getText() ;
        } catch (Exception e) {
            color ="----";
        }
        return color;
    }

    public boolean selectNoAndClickContinue() {


        List<WebElement> oRadioButton = getDriver().findElements(By.name("Correct"));
        oRadioButton.get(1).click();


        WebElement submitElement = getDriver().findElement(By.className("button"));
        submitElement.submit();

        WebElement vrmElement = (new WebDriverWait(getDriver(), 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("Vrm")));

        return vrmElement.isDisplayed();
    }

    public boolean clickSearchAgain() {
        WebElement webElement = getDriver().findElement(By.linkText("Search again"));
        webElement.click();
        WebElement vrmElement = (new WebDriverWait(getDriver(), 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("Vrm")));

        return vrmElement.isDisplayed();

    }
}
