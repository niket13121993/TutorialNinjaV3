package org.trycatch.v3.pages;

import org.openqa.selenium.By;
import org.trycatch.v3.driver.DriverFactory;

public class LandingPage extends BasePage{

    By myAccountMenu = By.xpath("//span[text()='My Account']");
    By loginMenu = By.xpath("//a[text()='Login']");

    public void navigateToLoginPage() {
        DriverFactory.getDriver().findElement(myAccountMenu).click();
        DriverFactory.getDriver().findElement(loginMenu).click();
    }
}
