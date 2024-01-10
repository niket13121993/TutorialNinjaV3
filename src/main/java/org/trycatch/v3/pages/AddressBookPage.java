package org.trycatch.v3.pages;

import org.openqa.selenium.By;
import org.trycatch.v3.driver.DriverFactory;

import java.util.ArrayList;
import java.util.List;

public class AddressBookPage extends BasePage{

    By newAddressButton = By.xpath("//a[text()='New Address']");
    By sectionHeaderField = By.xpath("//div[@id='content']/h2");
    By allAddressTitles = By.xpath("//div[@id='content']//table//td[1]");
    By successMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    String dynamicEditIconXpath = "//div[@id='content']//table//td[contains(text(),'%s')]/following-sibling::td/a[text()='Edit']";


    public void navigateToNewAddressPage() {
        DriverFactory.getDriver().findElement(newAddressButton).click();
    }
    public void clickEditIconForMatchingAddress() {

    }
    public List<String> getAllAddresses() {
        List<String> addressTitles = new ArrayList<>();
        DriverFactory.getDriver().findElements(allAddressTitles)
                .forEach(x -> addressTitles.add(x.getText()));
        return addressTitles;
    }

    public boolean isMatchingAddressPresentInTheList(String matchingText) {
        List<String> allAddressEntries = getAllAddresses();
        for (String x: allAddressEntries) {
            if(x.contains("Aaron Paul")) {
                return true;
            }
        }
        return false;
    }

    public String getSectionHeader() {
        return DriverFactory.getDriver().findElement(sectionHeaderField).getText();
    }

    public String getAddAddressSuccessMessage() {
        return DriverFactory.getDriver().findElement(successMessage).getText();
    }

    public void navigateToEditAddressPage(String matchingAddressText) {
        DriverFactory.getDriver().findElement(By.xpath(String.format(dynamicEditIconXpath, matchingAddressText))).click();
    }
}
