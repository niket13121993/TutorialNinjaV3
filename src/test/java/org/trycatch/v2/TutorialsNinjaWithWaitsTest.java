package org.trycatch.v2;

import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.trycatch.v3.driver.DriverFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TutorialsNinjaWithWaitsTest {
    @Test
    public void TC01_verifyUserIsRedirectedToHomePageOnLoginUsingValidUsernameAndPassword() {

        //Declare all locators for the required fields.
        String myAccountXpathString = "//span[text()='My Account']";
        String loginLinkXpathString = "//a[text()='Login']";
        String emailFieldIdString = "input-email";
        String passwordFieldIdString = "input-password";
        String loginButtonXpathString = "//input[@value='Login']";

        System.out.println("Test case started...TC01");
        //Launch the browser
        WebDriver browser = new ChromeDriver();
        //Maximize Window
        browser.manage().window().maximize();
        //Initialize Implicit wait
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Navigate To Website
        browser.navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        browser.findElement(By.xpath(myAccountXpathString)).click();
        //Click on Login link on sub options under my account.
        browser.findElement(By.xpath(loginLinkXpathString)).click();
        //Enter valid username
        browser.findElement(By.id(emailFieldIdString)).sendKeys("qa.cshah@gmail.com");
        //Enter valid password
        browser.findElement(By.id(passwordFieldIdString)).sendKeys("qa.cshah123");
        //click on login button
        browser.findElement(By.xpath(loginButtonXpathString)).click();
        //Get Page title and verify it.
        String expTitle = "My Account";
        String actTitle = browser.getTitle();
        Assert.assertEquals(actTitle, expTitle);
        //Quit the browser
        browser.quit();
        System.out.println("Test case ended...TC01");
    }
    @Test
    public void TC02_verifyUserRemainsOnLoginPageOnLoginUsingValidUsernameAndInvalidPassword(){

        //Declare all locators for the required fields.
        String myAccountXpathString = "//span[text()='My Account']";
        String loginLinkXpathString = "//a[text()='Login']";
        String emailFieldIdString = "input-email";
        String passwordFieldIdString = "input-password";
        String loginButtonXpathString = "//input[@value='Login']";
        String invalidLoginAlertXpathString = "//div[text()='Warning: No match for E-Mail Address and/or Password.']";

        System.out.println("Test case started...TC02");
        //Launch the browser
        WebDriver browser = new ChromeDriver();
        //Maximize Window
        browser.manage().window().maximize();
        //Initialize Implicit wait
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Navigate To Website
        browser.navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        browser.findElement(By.xpath(myAccountXpathString)).click();
        //Click on Login link on sub options under my account.
        browser.findElement(By.xpath(loginLinkXpathString)).click();
        //Enter valid username
        browser.findElement(By.id(emailFieldIdString)).sendKeys("qa.cshah@gmail.com");
        //Enter invalid password
        browser.findElement(By.id(passwordFieldIdString)).sendKeys("qa.cshah1234");
        //click on login button
        browser.findElement(By.xpath(loginButtonXpathString)).click();
        //Get Page title and verify it.
        String expTitle = "Account Login";
        String actTitle = browser.getTitle();
        Assert.assertEquals(actTitle, expTitle);
        //Get error message for invalid credentials and verify it.
        String expErrorMsg = "Warning: No match for E-Mail Address and/or Password.";
        String actErrorMsg = browser.findElement(By.xpath(invalidLoginAlertXpathString)).getText();
        Assert.assertEquals(actErrorMsg, expErrorMsg);
        //Quit the browser
        browser.quit();
        System.out.println("Test case ended...TC02");
    }
    @Test
    public void TC03_verifyUserRemainsOnLoginPageOnLoginUsingBlankUsernameAndPassword() {

        //Declare all locators for the required fields.
        String myAccountXpathString = "//span[text()='My Account']";
        String loginLinkXpathString = "//a[text()='Login']";
        String emailFieldIdString = "input-email";
        String passwordFieldIdString = "input-password";
        String loginButtonXpathString = "//input[@value='Login']";
        String invalidLoginAlertXpathString = "//div[text()='Warning: No match for E-Mail Address and/or Password.']";

        System.out.println("Test case started...TC03");
        //Launch the browser
        WebDriver browser = new ChromeDriver();
        //Maximize Window
        browser.manage().window().maximize();
        //Initialize Implicit wait
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Navigate To Website
        browser.navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        browser.findElement(By.xpath(myAccountXpathString)).click();
        //Click on Login link on sub options under my account.
        browser.findElement(By.xpath(loginLinkXpathString)).click();
        //click on login button
        browser.findElement(By.xpath(loginButtonXpathString)).click();
        //Get Page title and verify it.
        String expTitle = "Account Login";
        String actTitle = browser.getTitle();
        Assert.assertEquals(actTitle, expTitle);
        //Get error message for invalid credentials and verify it.
        String expErrorMsg = "Warning: No match for E-Mail Address and/or Password.";
        String actErrorMsg = browser.findElement(By.xpath(invalidLoginAlertXpathString)).getText();
        Assert.assertEquals(actErrorMsg, expErrorMsg);
        //Quit the browser
        browser.quit();
        System.out.println("Test case ended...TC03");
    }
    @Test
    public void TC04_verifyUserRemainsOnLoginPageOnLoginUsingValidUsernameAndBlankPassword() {

        //Declare all locators for the required fields.
        String myAccountXpathString = "//span[text()='My Account']";
        String loginLinkXpathString = "//a[text()='Login']";
        String emailFieldIdString = "input-email";
        String passwordFieldIdString = "input-password";
        String loginButtonXpathString = "//input[@value='Login']";
        String invalidLoginAlertXpathString = "//div[text()='Warning: No match for E-Mail Address and/or Password.']";

        System.out.println("Test case started...TC04");
        //Launch the browser
        WebDriver browser = new ChromeDriver();
        //Maximize Window
        browser.manage().window().maximize();
        //Initialize Implicit wait
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Navigate To Website
        browser.navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        browser.findElement(By.xpath(myAccountXpathString)).click();
        //Click on Login link on sub options under my account.
        browser.findElement(By.xpath(loginLinkXpathString)).click();
        //Enter valid username
        browser.findElement(By.id(emailFieldIdString)).sendKeys("qa.cshah@gmail.com");
        //click on login button
        browser.findElement(By.xpath(loginButtonXpathString)).click();
        //Get Page title and verify it.
        String expTitle = "Account Login";
        String actTitle = browser.getTitle();
        Assert.assertEquals(actTitle, expTitle);
        //Get error message for invalid credentials and verify it.
        String expErrorMsg = "Warning: No match for E-Mail Address and/or Password.";
        String actErrorMsg = browser.findElement(By.xpath(invalidLoginAlertXpathString)).getText();
        Assert.assertEquals(actErrorMsg, expErrorMsg);
        //Quit the browser
        browser.quit();
        System.out.println("Test case ended...TC04");
    }
    @Test
    public void TC05_verifyUserIsNavigatedToForgotPasswordPageOnClickingForgotPasswordLink() {

        //Declare all locators for the required fields.
        String myAccountXpathString = "//span[text()='My Account']";
        String loginLinkXpathString = "//a[text()='Login']";
        String forgotPasswordLinkXpathString = "//input[@id='input-password']/following-sibling::a";

        System.out.println("Test case started...TC05");
        //Launch the browser
        WebDriver browser = new ChromeDriver();
        //Maximize Window
        browser.manage().window().maximize();
        //Initialize Implicit wait
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Navigate To Website
        browser.navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        browser.findElement(By.xpath(myAccountXpathString)).click();
        //Click on Login link on sub options under my account.
        browser.findElement(By.xpath(loginLinkXpathString)).click();
        //Click on ForgotPassword link
        browser.findElement(By.xpath(forgotPasswordLinkXpathString)).click();
        //Get Page title and verify it.
        String expTitle = "Forgot Your Password?";
        String actTitle = browser.getTitle();
        Assert.assertEquals(actTitle, expTitle, "Title did not match");
        //Quit the browser
        browser.quit();
        System.out.println("Test case ended...TC05");
    }
    @Test
    public void TC06_verifyErrorMessageOnForgotPasswordPageWhenInvalidEmailAddressIsSubmitted() {

        //Declare all locators for the required fields.
        String myAccountXpathString = "//span[text()='My Account']";
        String loginLinkXpathString = "//a[text()='Login']";
        String forgotPasswordLinkXpathString = "//input[@id='input-password']/following-sibling::a";
        String emailAddressIdString = "input-email";
        String continueBtnXpathString = "//input[@value='Continue']";
        String invalidEmailAlertXpathString = "//div[text()='Warning: The E-Mail Address was not found in our records, please try again!']";

        System.out.println("Test case started...TC06");
        //Launch the browser
        WebDriver browser = new ChromeDriver();
        //Maximize Window
        browser.manage().window().maximize();
        //Initialize Implicit wait
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Navigate To Website
        browser.navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        browser.findElement(By.xpath(myAccountXpathString)).click();
        //Click on Login link on sub options under my account.
        browser.findElement(By.xpath(loginLinkXpathString)).click();
        //Click on ForgotPassword link
        browser.findElement(By.xpath(forgotPasswordLinkXpathString)).click();
        //Enter some invalid email address
        browser.findElement(By.id(emailAddressIdString)).sendKeys("abcdef@abcdef.com");
        //Click on continue button
        browser.findElement(By.xpath(continueBtnXpathString)).click();
        //Get Page title and verify it.
        String expTitle = "Forgot Your Password?";
        String actTitle = browser.getTitle();
        Assert.assertEquals(actTitle, expTitle);
        //Get Error message and verify it
        String expErrorMsg = "Warning: The E-Mail Address was not found in our records, please try again!";
        String actErrorMsg = browser.findElement(By.xpath(invalidEmailAlertXpathString)).getText();
        Assert.assertEquals(actErrorMsg, expErrorMsg);
        //Quit the browser
        browser.quit();
        System.out.println("Test case ended...TC06");
    }
    @Test
    public void TC07_verifyUserIsNavigatedToAddAddressPageOnClickingAddAddressButton() {

        //Declare all locators for the required fields.
        String myAccountXpathString = "//span[text()='My Account']";
        String loginLinkXpathString = "//a[text()='Login']";
        String emailFieldIdString = "input-email";
        String passwordFieldIdString = "input-password";
        String loginButtonXpathString = "//input[@value='Login']";
        String addressBookLinkXpathString = "//a[text()='Address Book']";
        String sectionHeaderXPathString = "//div[@id='content']/h2";
        String newAddressButtonXpathString = "//a[text()='New Address']";

        System.out.println("Test case started...TC07");
        //Launch the browser
        WebDriver browser = new ChromeDriver();
        //Maximize Window
        browser.manage().window().maximize();
        //Initialize Implicit wait
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Navigate To Website
        browser.navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        browser.findElement(By.xpath(myAccountXpathString)).click();
        //Click on Login link on sub options under my account.
        browser.findElement(By.xpath(loginLinkXpathString)).click();
        //Enter valid username
        browser.findElement(By.id(emailFieldIdString)).sendKeys("qa.cshah@gmail.com");
        //Enter valid password
        browser.findElement(By.id(passwordFieldIdString)).sendKeys("qa.cshah123");
        //click on login button
        browser.findElement(By.xpath(loginButtonXpathString)).click();
        //Get Page title and verify it.
        String expLHomePageTitle = "My Account";
        String actHomePageTitle = browser.getTitle();
        Assert.assertEquals(actHomePageTitle, expLHomePageTitle);
        //Click on Address Book link from right menu
        browser.findElement(By.xpath(addressBookLinkXpathString)).click();
        //Verify Page Title
        String expAddressBookListingPageTitle = "Address Book";
        String actAddressBookListingPageTitle = browser.getTitle();
        Assert.assertEquals(actAddressBookListingPageTitle, expAddressBookListingPageTitle);
        //Verify section header
        String expAddressBookListingPageSectionHeaderTitle = "Address Book Entries";
        String actAddressBookListingPageSectionHeaderTitle = browser.findElement(By.xpath(sectionHeaderXPathString)).getText();
        Assert.assertEquals(actAddressBookListingPageSectionHeaderTitle, expAddressBookListingPageSectionHeaderTitle);
        //Click on New Address button
        browser.findElement(By.xpath(newAddressButtonXpathString)).click();
        //Verify Page Title
        String expAddAddressPageTitle = "Address Book";
        String actAddAddressPageTitle = browser.getTitle();
        Assert.assertEquals(actAddAddressPageTitle, expAddAddressPageTitle);
        //Verify section header
        String expAddAddressPageSectionHeaderTitle = "Add Address";
        String actAddAddressPageSectionHeaderTitle = browser.findElement(By.xpath(sectionHeaderXPathString)).getText();
        Assert.assertEquals(actAddAddressPageSectionHeaderTitle, expAddAddressPageSectionHeaderTitle);
        //Quit the browser
        browser.quit();
        System.out.println("Test case ended...TC07");
    }
    @Test
    public void TC08_verifyUserIsAbleToAddNewAddressByProvidingDataInAllFields() {

        //Declare all locators for the required fields.
        String myAccountXpathString = "//span[text()='My Account']";
        String loginLinkXpathString = "//a[text()='Login']";
        String emailFieldIdString = "input-email";
        String passwordFieldIdString = "input-password";
        String loginButtonXpathString = "//input[@value='Login']";
        String addressBookLinkXpathString = "//a[text()='Address Book']";
        String sectionHeaderXPathString = "//div[@id='content']/h2";
        String newAddressButtonXpathString = "//a[text()='New Address']";
        String firstNameIdString = "input-firstname";
        String lastNameIdString = "input-lastname";
        String companyIdString = "input-company";
        String addressLine1IdString = "input-address-1";
        String addressLine2IdString = "input-address-2";
        String cityIdString = "input-city";
        String postCodeIdString = "input-postcode";
        String countryIdString = "input-country";
        String stateIdString = "input-zone";
        String radioDefaultAddressYesXpathString = "//label[text()='Default Address']/following-sibling::div/label[text()='Yes']/input";
        String radioDefaultAddressNoXpathString = "//label[text()='Default Address']/following-sibling::div/label[text()='No']/input";
        String countinueBtnXpathString = "//input[@value='Continue']";
        String listAllAddressNamesXpathString = "//div[@id='content']//table//td[1]";
        String successMsgXpathString = "//div[@class='alert alert-success alert-dismissible']";
        String firstNameData = "Aaron";
        String lastNameData= "Paul";
        String companyNameData = "Breaking Bad";
        String addressLine1Data = "322 16th street sw";
        String cityData = "albuquerque";
        String postCodeData = "87104";
        String countryData = "United States";
        String stateData = "New Mexico";
        boolean isDefaultAddress = false;

        System.out.println("Test case started...TC08");
        //Launch the browser
        WebDriver browser = new ChromeDriver();
        //Maximize Window
        browser.manage().window().maximize();
        //Initialize Implicit wait
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Navigate To Website
        browser.navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        browser.findElement(By.xpath(myAccountXpathString)).click();
        //Click on Login link on sub options under my account.
        browser.findElement(By.xpath(loginLinkXpathString)).click();
        //Enter valid username
        browser.findElement(By.id(emailFieldIdString)).sendKeys("qa.cshah@gmail.com");
        //Enter valid password
        browser.findElement(By.id(passwordFieldIdString)).sendKeys("qa.cshah123");
        //click on login button
        browser.findElement(By.xpath(loginButtonXpathString)).click();
        //Get Page title and verify it.
        String expHomePageTitle = "My Account";
        String actHomePageTitle = browser.getTitle();
        Assert.assertEquals(actHomePageTitle, expHomePageTitle);
        //Click on Address Book link from right menu
        browser.findElement(By.xpath(addressBookLinkXpathString)).click();
        //Verify Page Title
        String expAddressBookListingPageTitle = "Address Book";
        String actAddressBookListingPageTitle = browser.getTitle();
        Assert.assertEquals(actAddressBookListingPageTitle, expAddressBookListingPageTitle);
        //Verify section header
        String expAddressBookListingPageSectionHeaderTitle = "Address Book Entries";
        String actAddressBookListingPageSectionHeaderTitle = browser.findElement(By.xpath(sectionHeaderXPathString)).getText();
        Assert.assertEquals(actAddressBookListingPageSectionHeaderTitle, expAddressBookListingPageSectionHeaderTitle);
        //Click on New Address button
        browser.findElement(By.xpath(newAddressButtonXpathString)).click();
        //Verify Page Title
        String expAddAddressPageTitle = "Address Book";
        String actAddAddressPageTitle = browser.getTitle();
        Assert.assertEquals(actAddAddressPageTitle, expAddAddressPageTitle);
        //Verify section header
        String expAddAddressPageSectionHeaderTitle = "Add Address";
        String actAddAddressPageSectionHeaderTitle = browser.findElement(By.xpath(sectionHeaderXPathString)).getText();
        Assert.assertEquals(actAddAddressPageSectionHeaderTitle, expAddAddressPageSectionHeaderTitle);
        //Fill up the form.
        browser.findElement(By.id(firstNameIdString)).sendKeys(firstNameData);
        browser.findElement(By.id(lastNameIdString)).sendKeys(lastNameData);
        browser.findElement(By.id(companyIdString)).sendKeys(companyNameData);
        browser.findElement(By.id(addressLine1IdString)).sendKeys(addressLine1Data);
        browser.findElement(By.id(addressLine2IdString)).sendKeys("");
        browser.findElement(By.id(cityIdString)).sendKeys(cityData);
        browser.findElement(By.id(postCodeIdString)).sendKeys(postCodeData);
        Select countryDropDown = new Select(browser.findElement(By.id(countryIdString)));
        countryDropDown.selectByVisibleText(countryData);
        //Initialize Explicit wait
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(30));
        //Wait for JQuery to complete to load state drop down.
        String jQueryActiveScript = "return jQuery.active == 0";
        wait.until(ExpectedConditions.jsReturnsValue(jQueryActiveScript));
        Select stateDropDown = new Select(browser.findElement(By.id(stateIdString)));
        stateDropDown.selectByVisibleText(stateData);
//        browser.findElement(
//                By.xpath(isDefaultAddress
//                        ? radioDefaultAddressYesXpathString
//                        : radioDefaultAddressNoXpathString)).click();
        if(isDefaultAddress) {
            browser.findElement(By.xpath(radioDefaultAddressYesXpathString)).click();
        }else {
            browser.findElement(By.xpath(radioDefaultAddressNoXpathString)).click();
        }
        //Click on continue button to submit the data
        browser.findElement(By.xpath(countinueBtnXpathString)).click();
        //Verify user is redirected to listing page and verify its title.
        actAddressBookListingPageTitle = browser.getTitle();
        Assert.assertEquals(actAddressBookListingPageTitle, expAddressBookListingPageTitle);
        //Verify success message
        String expSuccessMsg = "Your address has been successfully added";
        String actSuccessMsg = browser.findElement(By.xpath(successMsgXpathString)).getText();
        Assert.assertEquals(actSuccessMsg, expSuccessMsg);
        //Verify username entry exist in the address listing table.
        boolean isEntryFound = false;
        List<String> allAddressEntries = new ArrayList<>();
        browser.findElements(By.xpath(listAllAddressNamesXpathString))
                .forEach(x -> allAddressEntries.add(x.getText()));
        for (String x: allAddressEntries) {
            if(x.contains("Aaron Paul")) {
                isEntryFound = true;
                break;
            }
        }
        if(!isEntryFound) {
            Assert.fail("Entry not found in ");
        }
        //Quit the browser
        browser.quit();
        System.out.println("Test case ended...TC08");
    }
    @Test
    public void TC09_verifyDataIsRetainedForExistingAddressOnEditAddressScreen() {

        //Declare all locators for the required fields.
        String myAccountXpathString = "//span[text()='My Account']";
        String loginLinkXpathString = "//a[text()='Login']";
        String emailFieldIdString = "input-email";
        String passwordFieldIdString = "input-password";
        String loginButtonXpathString = "//input[@value='Login']";
        String addressBookLinkXpathString = "//a[text()='Address Book']";
        String sectionHeaderXPathString = "//div[@id='content']/h2";
        String newAddressButtonXpathString = "//a[text()='New Address']";
        String firstNameIdString = "input-firstname";
        String lastNameIdString = "input-lastname";
        String companyIdString = "input-company";
        String addressLine1IdString = "input-address-1";
        String addressLine2IdString = "input-address-2";
        String cityIdString = "input-city";
        String postCodeIdString = "input-postcode";
        String countryIdString = "input-country";
        String stateIdString = "input-zone";
        String radioDefaultAddressYesXpathString = "//label[text()='Default Address']/following-sibling::div/label[text()='Yes']/input";
        String radioDefaultAddressNoXpathString = "//label[text()='Default Address']/following-sibling::div/label[text()='No']/input";
        String countinueBtnXpathString = "//input[@value='Continue']";
        String listAllAddressNamesXpathString = "//div[@id='content']//table//td[1]";
        String firstNameData = "Aaron";
        String lastNameData= "Paul";
        String companyNameData = "Breaking Bad";
        String addressLine1Data = "322 16th street sw";
        String cityData = "albuquerque";
        String postCodeData = "87104";
        String countryData = "United States";
        String stateData = "New Mexico";
        boolean isDefaultAddress = false;

        System.out.println("Test case started...TC09");
        //Launch the browser
        WebDriver browser = new ChromeDriver();
        //Maximize Window
        browser.manage().window().maximize();
        //Initialize Implicit wait
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Navigate To Website
        browser.navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        browser.findElement(By.xpath(myAccountXpathString)).click();
        //Click on Login link on sub options under my account.
        browser.findElement(By.xpath(loginLinkXpathString)).click();
        //Enter valid username
        browser.findElement(By.id(emailFieldIdString)).sendKeys("qa.cshah@gmail.com");
        //Enter valid password
        browser.findElement(By.id(passwordFieldIdString)).sendKeys("qa.cshah123");
        //click on login button
        browser.findElement(By.xpath(loginButtonXpathString)).click();
        //Get Page title and verify it.
        String expHomePageTitle = "My Account";
        String actHomePageTitle = browser.getTitle();
        Assert.assertEquals(actHomePageTitle, expHomePageTitle);
        //Click on Address Book link from right menu
        browser.findElement(By.xpath(addressBookLinkXpathString)).click();
        //Verify Page Title
        String expAddressBookListingPageTitle = "Address Book";
        String actAddressBookListingPageTitle = browser.getTitle();
        Assert.assertEquals(actAddressBookListingPageTitle, expAddressBookListingPageTitle);
        //Verify section header
        String expAddressBookListingPageSectionHeaderTitle = "Address Book Entries";
        String actAddressBookListingPageSectionHeaderTitle = browser.findElement(By.xpath(sectionHeaderXPathString)).getText();
        Assert.assertEquals(actAddressBookListingPageSectionHeaderTitle, expAddressBookListingPageSectionHeaderTitle);
        //Locate the above created address and click on Edit icon.
        //Approach 1:
//        List<WebElement> addressRows = browser.findElements(By.xpath("//div[@id='content']//table//tr"));
        boolean isRequiredRowFound = false;
        String addressName = "Aaron Paul";
        //Approach 2:
        String dynamicXpathEditLink = "//div[@id='content']//table//td[contains(text(),'Aaron Paul')]/following-sibling::td/a[text()='Edit']";
        browser.findElement(By.xpath(dynamicXpathEditLink)).click();
        //Print values from each field
        String actFirstName = browser.findElement(By.id(firstNameIdString)).getAttribute("Value");
        Assert.assertEquals(actFirstName, firstNameData);
        Assert.assertEquals(browser.findElement(By.id(lastNameIdString)).getAttribute("Value"), lastNameData);
        Assert.assertEquals(browser.findElement(By.id(companyIdString)).getAttribute("Value"), companyNameData);
        Assert.assertEquals(browser.findElement(By.id(addressLine1IdString)).getAttribute("Value"), addressLine1Data);
        Assert.assertEquals(browser.findElement(By.id(addressLine2IdString)).getAttribute("Value"), "");
        Assert.assertEquals(browser.findElement(By.id(cityIdString)).getAttribute("Value"), cityData);
        Assert.assertEquals(browser.findElement(By.id(postCodeIdString)).getAttribute("Value"), postCodeData);
        Select countryDropdown = new Select(browser.findElement(By.id(countryIdString)));
        Assert.assertEquals(countryDropdown.getFirstSelectedOption().getText(), countryData);
        Select stateDropdown = new Select(browser.findElement(By.id(stateIdString)));
        Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(), stateData);
        Assert.assertEquals(browser.findElement(By.xpath(radioDefaultAddressYesXpathString)).isSelected(), isDefaultAddress);
        //Quit the browser
        browser.quit();
        System.out.println("Test case ended...TC09");
    }
    @Test
    public void TC10_verifyErrorMessageForAllMandatoryFieldsWhenNoDataIsEntered() {

        //Declare all locators for the required fields.
        String myAccountXpathString = "//span[text()='My Account']";
        String loginLinkXpathString = "//a[text()='Login']";
        String emailFieldIdString = "input-email";
        String passwordFieldIdString = "input-password";
        String loginButtonXpathString = "//input[@value='Login']";
        String addressBookLinkXpathString = "//a[text()='Address Book']";
        String sectionHeaderXPathString = "//div[@id='content']/h2";
        String newAddressButtonXpathString = "//a[text()='New Address']";
        String countinueBtnXpathString = "//input[@value='Continue']";
        String firstNameMandatoryErrorXpathString = "//input[@placeholder='First Name']//following-sibling::div[@class='text-danger']";
        String lastNameMandatoryErrorXpathString = "//input[@placeholder='Last Name']//following-sibling::div[@class='text-danger']";
        String address1MandatoryErrorXpathString = "//input[@placeholder='Address 1']//following-sibling::div[@class='text-danger']";
        String cityMandatoryErrorXpathString = "//input[@placeholder='City']//following-sibling::div[@class='text-danger']";
        String posCodeMandatoryErrorXpathString = "//input[@placeholder='Post Code']//following-sibling::div[@class='text-danger']";
        String stateMandatoryErrorXpathString = "//select[@name='zone_id']//following-sibling::div[@class='text-danger']";
        String allErrorAlertsXpathString = "//div[@class='text-danger']";

        System.out.println("Test case started...TC10");
        //Launch the browser
        WebDriver browser = new ChromeDriver();
        //Maximize Window
        browser.manage().window().maximize();
        //Initialize Implicit wait
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Navigate To Website
        browser.navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        browser.findElement(By.xpath(myAccountXpathString)).click();
        //Click on Login link on sub options under my account.
        browser.findElement(By.xpath(loginLinkXpathString)).click();
        //Enter valid username
        browser.findElement(By.id(emailFieldIdString)).sendKeys("qa.cshah@gmail.com");
        //Enter valid password
        browser.findElement(By.id(passwordFieldIdString)).sendKeys("qa.cshah123");
        //click on login button
        browser.findElement(By.xpath(loginButtonXpathString)).click();
        //Get Page title and verify it.
        String expHomePageTitle = "My Account";
        String actHomePageTitle = browser.getTitle();
        Assert.assertEquals(actHomePageTitle, expHomePageTitle);
        //Click on Address Book link from right menu
        browser.findElement(By.xpath(addressBookLinkXpathString)).click();
        //Verify Page Title
        String expAddressBookListingPageTitle = "Address Book";
        String actAddressBookListingPageTitle = browser.getTitle();
        Assert.assertEquals(actAddressBookListingPageTitle, expAddressBookListingPageTitle);
        //Verify section header
        String expAddressBookListingPageSectionHeaderTitle = "Address Book Entries";
        String actAddressBookListingPageSectionHeaderTitle = browser.findElement(By.xpath(sectionHeaderXPathString)).getText();
        Assert.assertEquals(actAddressBookListingPageSectionHeaderTitle, expAddressBookListingPageSectionHeaderTitle);
        //Click on New Address button
        browser.findElement(By.xpath(newAddressButtonXpathString)).click();
        //Verify Page Title
        String expAddAddressPageTitle = "Address Book";
        String actAddAddressPageTitle = browser.getTitle();
        Assert.assertEquals(actAddAddressPageTitle, expAddAddressPageTitle);
        //Verify section header
        String expAddAddressPageSectionHeaderTitle = "Add Address";
        String actAddAddressPageSectionHeaderTitle = browser.findElement(By.xpath(sectionHeaderXPathString)).getText();
        Assert.assertEquals(actAddAddressPageSectionHeaderTitle, expAddAddressPageSectionHeaderTitle);
        //Do not enter data in any field
        //Click on continue button.
        browser.findElement(By.xpath(countinueBtnXpathString)).click();
        //Print all the error messages.
        Assert.assertEquals(browser.findElement(By.xpath(firstNameMandatoryErrorXpathString)).getText(), "First Name must be between 1 and 32 characters!");
        Assert.assertEquals(browser.findElement(By.xpath(lastNameMandatoryErrorXpathString)).getText(), "Last Name must be between 1 and 32 characters!");
        Assert.assertEquals(browser.findElement(By.xpath(address1MandatoryErrorXpathString)).getText(), "Address must be between 3 and 128 characters!");
        Assert.assertEquals(browser.findElement(By.xpath(cityMandatoryErrorXpathString)).getText(), "City must be between 2 and 128 characters!");
        Assert.assertEquals(browser.findElement(By.xpath(posCodeMandatoryErrorXpathString)).getText(), "Postcode must be between 2 and 10 characters!");
        Assert.assertEquals(browser.findElement(By.xpath(stateMandatoryErrorXpathString)).getText(), "Please select a region / state!");

        //Quit the browser
        browser.quit();
        System.out.println("Test case ended...TC10");
    }
    @Test
    public void TC11_verifyMatchingProductsAreDisplayedAsPerProvidedSearchCriteria() {

        //Declare all locators for the required fields.
        String myAccountXpathString = "//span[text()='My Account']";
        String loginLinkXpathString = "//a[text()='Login']";
        String emailFieldIdString = "input-email";
        String passwordFieldIdString = "input-password";
        String loginButtonXpathString = "//input[@value='Login']";
        String topMenuDynamicXpathString = "//a[text()='%s']";
        String subMenuDynamicXpathString = "//a[text()='%s']/parent::li/descendant::a[starts-with(text(),'%s')]";
        String listOfProductsXpathString = "//div[contains(@class,'product-list')]";
        String listViewIconIdString = "list-view";
        String searchBoxNameString = "search";

        System.out.println("Test case started...TC11");
        //Launch the browser
        WebDriver browser = new ChromeDriver();
        //Maximize Window
        browser.manage().window().maximize();
        //Initialize Implicit wait
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Navigate To Website
        browser.navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        browser.findElement(By.xpath(myAccountXpathString)).click();
        //Click on Login link on sub options under my account.
        browser.findElement(By.xpath(loginLinkXpathString)).click();
        //Enter valid username
        browser.findElement(By.id(emailFieldIdString)).sendKeys("qa.cshah@gmail.com");
        //Enter valid password
        browser.findElement(By.id(passwordFieldIdString)).sendKeys("qa.cshah123");
        //click on login button
        browser.findElement(By.xpath(loginButtonXpathString)).click();
        //Get Page title and verify it.
        String expHomePageTitle = "My Account";
        String actHomePageTitle = browser.getTitle();
        Assert.assertEquals(actHomePageTitle, expHomePageTitle);
        browser.findElement(By.name(searchBoxNameString)).sendKeys("MacBook");
        browser.findElement(By.name(searchBoxNameString)).sendKeys(Keys.ENTER);
        browser.findElement(By.id(listViewIconIdString)).click();
        //Print product details.
        List<String> actProductTitles = new ArrayList<>();
        List<String> actProductPrices = new ArrayList<>();
        List<String> actProductTaxPrices = new ArrayList<>();
        List<String> expProductTitles = new ArrayList<>(Arrays.asList("MacBook", "MacBook Air", "MacBook Pro"));
        List<String> expProductPrices = new ArrayList<>(Arrays.asList("$500.00", "$1,000.00", "$2,000.00"));
        List<String> expProductTaxPrices = new ArrayList<>(Arrays.asList("Ex Tax:$500.00", "Ex Tax:$1,000.00", "Ex Tax:$2,000.00"));

        browser.findElements(By.xpath(listOfProductsXpathString)).forEach(
                x -> {
                    actProductTitles.add(x.findElement(By.xpath(".//h4/a")).getText());
                    actProductPrices.add(Jsoup.parse(x.findElement(By.xpath(".//p[@class='price']")).getAttribute("outerHTML")).selectFirst("p").ownText());
                    actProductTaxPrices.add(x.findElement(By.xpath(".//span[@class='price-tax']")).getText());
                }
        );
        Assert.assertEquals(actProductTitles, expProductTitles);
        Assert.assertEquals(actProductPrices, expProductPrices);
        Assert.assertEquals(actProductTaxPrices, expProductTaxPrices);
        //Quit the browser
        browser.quit();
        System.out.println("Test case ended...TC11");
    }
    @Test
    public void TC12_verifyRelevantProductAreDisplayedWhenFilterUsingTopMenuCategory() {
        //Declare all locators for the required fields.
        String myAccountXpathString = "//span[text()='My Account']";
        String loginLinkXpathString = "//a[text()='Login']";
        String emailFieldIdString = "input-email";
        String passwordFieldIdString = "input-password";
        String loginButtonXpathString = "//input[@value='Login']";
        String topMenuDynamicXpathString = "//a[text()='%s']";
        String subMenuDynamicXpathString = "//a[text()='%s']/parent::li/descendant::a[starts-with(text(),'%s')]";
        String listOfProductsXpathString = "//div[contains(@class,'product-list')]";
        String listViewIconIdString = "list-view";

        System.out.println("Test case started...TC12");
        //Launch the browser
        WebDriver browser = new ChromeDriver();
        //Maximize Window
        browser.manage().window().maximize();
        //Initialize Implicit wait
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Navigate To Website
        browser.navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        browser.findElement(By.xpath(myAccountXpathString)).click();
        //Click on Login link on sub options under my account.
        browser.findElement(By.xpath(loginLinkXpathString)).click();
        //Enter valid username
        browser.findElement(By.id(emailFieldIdString)).sendKeys("qa.cshah@gmail.com");
        //Enter valid password
        browser.findElement(By.id(passwordFieldIdString)).sendKeys("qa.cshah123");
        //click on login button
        browser.findElement(By.xpath(loginButtonXpathString)).click();
        //Get Page title and verify it.
        String expHomePageTitle = "My Account";
        String actHomePageTitle = browser.getTitle();
        Assert.assertEquals(actHomePageTitle, expHomePageTitle);
        //Click over on "Desktops" Menu
        browser.findElement(By.xpath(String.format(topMenuDynamicXpathString, "Desktops"))).click();
        //Click on "Mac" from drop down
        browser.findElement(By.xpath(String.format(subMenuDynamicXpathString, "Desktops", "Mac"))).click();
        //Click on list view icon
        browser.findElement(By.id(listViewIconIdString)).click();
        List<String> actProductTitlesDesktop = new ArrayList<>();
        List<String> actProductPricesDesktop = new ArrayList<>();
        List<String> actProductTaxPricesDesktop = new ArrayList<>();
        List<String> expProductTitlesDesktop = new ArrayList<>(Arrays.asList("iMac"));
        List<String> expProductPricesDesktop = new ArrayList<>(Arrays.asList("$100.00"));
        List<String> expProductTaxPricesDesktop = new ArrayList<>(Arrays.asList("Ex Tax:$100.00"));

        //Print name and price of all products
        browser.findElements(By.xpath(listOfProductsXpathString)).forEach(
                x-> {
                    actProductTitlesDesktop.add(x.findElement(By.xpath(".//h4/a")).getText());
                    actProductPricesDesktop.add(Jsoup.parse(x.findElement(By.xpath(".//p[@class='price']")).getAttribute("outerHTML")).selectFirst("p").ownText());
                    actProductTaxPricesDesktop.add(x.findElement(By.xpath(".//span[@class='price-tax']")).getText());
                }
        );
        Assert.assertEquals(actProductTitlesDesktop, expProductTitlesDesktop);
        Assert.assertEquals(actProductPricesDesktop, expProductPricesDesktop);
        Assert.assertEquals(actProductTaxPricesDesktop, expProductTaxPricesDesktop);

        //Click over on "Phones & PDAs" Menu
        browser.findElement(By.xpath(String.format(topMenuDynamicXpathString, "Phones & PDAs"))).click();
        //Click on list view icon
        browser.findElement(By.id(listViewIconIdString)).click();
        List<String> actProductTitlesPhones = new ArrayList<>();
        List<String> actProductPricesPhones = new ArrayList<>();
        List<String> actProductTaxPricesPhones = new ArrayList<>();
        List<String> expProductTitlesPhones = new ArrayList<>(Arrays.asList("HTC Touch HD", "iPhone", "Palm Treo Pro"));
        List<String> expProductPricesPhones = new ArrayList<>(Arrays.asList("$100.00", "$101.00", "$279.99"));
        List<String> expProductTaxPricesPhones = new ArrayList<>(Arrays.asList("Ex Tax:$100.00", "Ex Tax:$101.00", "Ex Tax:$279.99"));
        //Print name and price of all products
        browser.findElements(By.xpath(listOfProductsXpathString)).forEach(
                x-> {
                    actProductTitlesPhones.add(x.findElement(By.xpath(".//h4/a")).getText());
                    actProductPricesPhones.add(Jsoup.parse(x.findElement(By.xpath(".//p[@class='price']")).getAttribute("outerHTML")).selectFirst("p").ownText());
                    actProductTaxPricesPhones.add(x.findElement(By.xpath(".//span[@class='price-tax']")).getText());
                }
        );
        Assert.assertEquals(actProductTitlesPhones, expProductTitlesPhones);
        Assert.assertEquals(actProductPricesPhones, expProductPricesPhones);
        Assert.assertEquals(actProductTaxPricesPhones, expProductTaxPricesPhones);

        //Quit the browser
        browser.quit();
        System.out.println("Test case ended...TC12");
    }
}
