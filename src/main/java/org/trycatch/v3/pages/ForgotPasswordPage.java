package org.trycatch.v3.pages;

import org.openqa.selenium.By;
import org.trycatch.v3.driver.DriverFactory;

public class ForgotPasswordPage extends BasePage{

    By emailAddressField = By.id("input-email");
    By continueButton = By.xpath("//input[@value='Continue']");
    By errorMessageField = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    public void enterEmailAddress(String email) {
        DriverFactory.getDriver().findElement(emailAddressField).sendKeys(email);
    }
    public void clickContinueButton() {
        DriverFactory.getDriver().findElement(continueButton).click();
    }
    public String getErrorMessage() {
        return DriverFactory.getDriver().findElement(errorMessageField).getText();
    }

}
