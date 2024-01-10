package org.trycatch.v3.pages;


import org.openqa.selenium.By;
import org.trycatch.v3.driver.DriverFactory;

public class LoginPage extends BasePage{

    By usernameField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton = By.xpath("//input[@value='Login']");
    By forgotPasswordLink = By.xpath("//input[@id='input-password']/following-sibling::a");
    By errorMessageField = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    public void performLogin(String username, String password) {
        DriverFactory.getDriver().findElement(usernameField).sendKeys(username);
        DriverFactory.getDriver().findElement(passwordField).sendKeys(password);
        DriverFactory.getDriver().findElement(loginButton).click();
    }

    public void navigateToForgotPasswordPage() {
        DriverFactory.getDriver().findElement(forgotPasswordLink).click();
    }
    public String getErrorMessage() {
        return DriverFactory.getDriver().findElement(errorMessageField).getText();
    }
}
