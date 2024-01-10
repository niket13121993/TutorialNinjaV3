package org.trycatch.v3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.trycatch.v3.driver.DriverFactory;

import java.time.Duration;

public class HomePage extends BasePage{

    By addressBookMenu = By.xpath("//a[text()='Address Book']");
    By desktopsMenu = By.xpath("//a[text()='Desktops']");
    By macMenuUnderDesktops = By.xpath("//a[text()='Desktops']/parent::li/descendant::a[starts-with(text(),'Mac')]");
    By phonesPdasMenu = By.xpath("//a[text()='Phones & PDAs']");
    By searchField = By.name("search");


    public void navigateToAddressBookPage() {
        DriverFactory.getDriver().findElement(addressBookMenu).click();
    }
    public void clickMacUnderDesktopsFromTopMenu() {
        DriverFactory.getDriver().findElement(desktopsMenu).click();
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(macMenuUnderDesktops));
        DriverFactory.getDriver().findElement(macMenuUnderDesktops).click();
    }
    public void clickPhonesAndPdasFromTopMenu() {
        DriverFactory.getDriver().findElement(phonesPdasMenu).click();
    }
    public void searchForProduct(String searchText) {
        DriverFactory.getDriver().findElement(searchField).sendKeys(searchText);
        DriverFactory.getDriver().findElement(searchField).sendKeys(Keys.ENTER);
    }

}
