package org.trycatch.v3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.trycatch.v3.driver.DriverFactory;

import java.time.Duration;

public class AddAddressPage extends BasePage{

    By sectionHeaderField = By.xpath("//div[@id='content']/h2");
    By firstNameField = By.id("input-firstname");
    By lastNameField = By.id("input-lastname");
    By companyField = By.id("input-company");
    By addressLineOneField = By.id("input-address-1");
    By addressLineTwoField = By.id("input-address-2");
    By cityField = By.id("input-city");
    By postCodeField = By.id("input-postcode");
    By countryField = By.id("input-country");
    By stateField = By.id("input-zone");
    By defaultAddressYesField = By.xpath("//label[text()='Default Address']/following-sibling::div/label[text()='Yes']/input");
    By defaultAddressNoField = By.xpath("//label[text()='Default Address']/following-sibling::div/label[text()='No']/input");
    By continueButton = By.xpath("//input[@value='Continue']");
    By firstNameErrMsgField = By.xpath("//input[@placeholder='First Name']//following-sibling::div[@class='text-danger']");
    By lastNameErrMsgField = By.xpath("//input[@placeholder='Last Name']//following-sibling::div[@class='text-danger']");
    By addressLineOneErrMsgField = By.xpath("//input[@placeholder='Address 1']//following-sibling::div[@class='text-danger']");
    By cityErrMsgField = By.xpath("//input[@placeholder='City']//following-sibling::div[@class='text-danger']");
    By postCodeErrMsgField = By.xpath("//input[@placeholder='Post Code']//following-sibling::div[@class='text-danger']");
    By stateErrMsgField = By.xpath("//select[@name='zone_id']//following-sibling::div[@class='text-danger']");


    public String getSectionHeader() {
        return DriverFactory.getDriver().findElement(sectionHeaderField).getText();
    }
    public void enterFirstName(String firstName) {
        DriverFactory.getDriver().findElement(firstNameField).sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        DriverFactory.getDriver().findElement(lastNameField).sendKeys(lastName);
    }
    public void enterCompanyName(String companyName) {
        DriverFactory.getDriver().findElement(companyField).sendKeys(companyName);
    }
    public void enterAddressLineOne(String addressLineOne) {
        DriverFactory.getDriver().findElement(addressLineOneField).sendKeys(addressLineOne);
    }
    public void enterAddressLineTwo(String addressLineTwo) {
        DriverFactory.getDriver().findElement(addressLineTwoField).sendKeys(addressLineTwo);
    }
    public void enterCity(String city) {
        DriverFactory.getDriver().findElement(cityField).sendKeys(city);
    }
    public void enterPostCode(String postCode) {
        DriverFactory.getDriver().findElement(postCodeField).sendKeys(postCode);
    }
    public void selectCountry(String county) {
        Select dropdown = new Select(DriverFactory.getDriver().findElement(countryField));
        dropdown.selectByVisibleText(county);

    }
    public void selectState(String state) {

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
        String jQueryActiveScript = "return jQuery.active == 0";
        wait.until(ExpectedConditions.jsReturnsValue(jQueryActiveScript));

        Select dropdown = new Select((DriverFactory.getDriver().findElement(stateField)));
        dropdown.selectByVisibleText(state);
    }
    public void selectDefaultAddress(boolean defaultAddress) {
        if(defaultAddress) {
            DriverFactory.getDriver().findElement(defaultAddressYesField).click();
        }
        else {
            DriverFactory.getDriver().findElement(defaultAddressNoField).click();
        }
    }
    public void clickContinueButton() {
        DriverFactory.getDriver().findElement(continueButton).click();
    }
    public String getFirstName() {
        return DriverFactory.getDriver().findElement(firstNameField).getAttribute("Value");
    }
    public String getLastName() {
        return DriverFactory.getDriver().findElement(lastNameField).getAttribute("Value");
    }
    public String getCompany() {
        return DriverFactory.getDriver().findElement(companyField).getAttribute("Value");
    }
    public String getAddressLineOne() {
        return DriverFactory.getDriver().findElement(addressLineOneField).getAttribute("Value");
    }
    public String getAddressLineTwo() {
        return DriverFactory.getDriver().findElement(addressLineTwoField).getAttribute("Value");
    }
    public String getCity() {
        return DriverFactory.getDriver().findElement(cityField).getAttribute("Value");
    }
    public String getPostCode() {
        return DriverFactory.getDriver().findElement(postCodeField).getAttribute("Value");
    }
    public String getCountry() {
        Select dropdown = new Select(DriverFactory.getDriver().findElement(countryField));
        return dropdown.getFirstSelectedOption().getText();
    }
    public String getState() {
        Select dropdown = new Select(DriverFactory.getDriver().findElement(stateField));
        return dropdown.getFirstSelectedOption().getText();
    }

    public boolean isDefaultAddress() {
        return DriverFactory.getDriver().findElement(defaultAddressYesField).isSelected();
    }

    public String getFirstNameErrMsg() {
        return DriverFactory.getDriver().findElement(firstNameErrMsgField).getText();
    }
    public String getLastNameErrMsg() {
        return DriverFactory.getDriver().findElement(lastNameErrMsgField).getText();
    }
    public String getAddressLineOneErrMsg() {
        return DriverFactory.getDriver().findElement(addressLineOneErrMsgField).getText();
    }
    public String getCityErrMsg() {
        return DriverFactory.getDriver().findElement(cityErrMsgField).getText();
    }
    public String getPostCodeErrMsg() {
        return DriverFactory.getDriver().findElement(postCodeErrMsgField).getText();
    }
    public String getStateErrMsg() {
        return DriverFactory.getDriver().findElement(stateErrMsgField).getText();
    }
}
