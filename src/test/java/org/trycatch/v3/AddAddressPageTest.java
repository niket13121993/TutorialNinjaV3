package org.trycatch.v3;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.trycatch.v3.pages.*;
import org.trycatch.v3.driver.DriverFactory;

public class AddAddressPageTest extends BaseTest {

    @Test
    public void TC08_verifyUserIsAbleToAddNewAddressByProvidingDataInAllFields() {

        //Declare all test data.
        String firstNameData = "Aaron";
        String lastNameData= "Paul";
        String companyNameData = "Breaking Bad";
        String addressLine1Data = "322 16th street sw";
        String cityData = "albuquerque";
        String postCodeData = "87104";
        String countryData = "United States";
        String stateData = "New Mexico";
        boolean isDefaultAddress = false;

        //Navigate To Website
        DriverFactory.getDriver().navigate().to("https://tutorialsninja.com/demo/");
        //Navigate to Login Page
        LandingPage landingPage = new LandingPage();
        landingPage.navigateToLoginPage();
        //Perform login action
        LoginPage loginPage = new LoginPage();
        loginPage.performLogin("qa.cshah@gmail.com", "qa.cshah123");
        //Verify user is on My account page
        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.getPageTitle(), "My Account");
        homePage.navigateToAddressBookPage();
        //Verify user is on Address Book Page
        AddressBookPage addressBookPage = new AddressBookPage();
        Assert.assertEquals(addressBookPage.getPageTitle(), "Address Book");
        Assert.assertEquals(addressBookPage.getSectionHeader(), "Address Book Entries");

        addressBookPage.navigateToNewAddressPage();
        AddAddressPage addAddressPage = new AddAddressPage();
        Assert.assertEquals(addAddressPage.getPageTitle(), "Address Book");
        Assert.assertEquals(addressBookPage.getSectionHeader(), "Add Address");

        //Fill up the form.
        addAddressPage.enterFirstName(firstNameData);;
        addAddressPage.enterLastName(lastNameData);
        addAddressPage.enterCompanyName(companyNameData);
        addAddressPage.enterAddressLineOne(addressLine1Data);
        addAddressPage.enterCity(cityData);
        addAddressPage.enterPostCode(postCodeData);
        addAddressPage.selectCountry(countryData);
        addAddressPage.selectState(stateData);
        addAddressPage.selectDefaultAddress(isDefaultAddress);
        addAddressPage.clickContinueButton();

        Assert.assertEquals(DriverFactory.getDriver().getTitle(), "Address Book");
        Assert.assertEquals(addressBookPage.getSectionHeader(), "Address Book Entries");
        Assert.assertEquals(addressBookPage.getAddAddressSuccessMessage(), "Your address has been successfully added");

        //Verify username entry exist in the address listing table.
        Assert.assertTrue(addressBookPage.isMatchingAddressPresentInTheList("Aaron Paul"), "Matching address with text Aaron Paul not found in the list.");
    }

    @Test
    public void TC09_verifyDataIsRetainedForExistingAddressOnEditAddressScreen() {

        //Declare all test data.
        String firstNameData = "Aaron";
        String lastNameData= "Paul";
        String companyNameData = "Breaking Bad";
        String addressLine1Data = "322 16th street sw";
        String cityData = "albuquerque";
        String postCodeData = "87104";
        String countryData = "United States";
        String stateData = "New Mexico";
        boolean isDefaultAddress = false;

        //Navigate To Website
        DriverFactory.getDriver().navigate().to("https://tutorialsninja.com/demo/");
        //Navigate to Login Page
        LandingPage landingPage = new LandingPage();
        landingPage.navigateToLoginPage();
        //Perform login action
        LoginPage loginPage = new LoginPage();
        loginPage.performLogin("qa.cshah@gmail.com", "qa.cshah123");        //Verify user is on My account page
        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.getPageTitle(), "My Account");
        homePage.navigateToAddressBookPage();
        //Verify user is on Address Book Page
        AddressBookPage addressBookPage = new AddressBookPage();
        Assert.assertEquals(DriverFactory.getDriver().getTitle(), "Address Book");
        Assert.assertEquals(addressBookPage.getSectionHeader(), "Address Book Entries");

        addressBookPage.navigateToEditAddressPage("Aaron Paul");
        AddAddressPage addAddressPage = new AddAddressPage();

        //Print values from each field
        Assert.assertEquals(addAddressPage.getFirstName(), firstNameData);
        Assert.assertEquals(addAddressPage.getLastName(), lastNameData);
        Assert.assertEquals(addAddressPage.getCompany(), companyNameData);
        Assert.assertEquals(addAddressPage.getAddressLineOne(), addressLine1Data);
        Assert.assertEquals(addAddressPage.getCity(), cityData);
        Assert.assertEquals(addAddressPage.getPostCode(), postCodeData);
        Assert.assertEquals(addAddressPage.getCountry(), countryData);
        Assert.assertEquals(addAddressPage.getState(), stateData);
        Assert.assertEquals(addAddressPage.isDefaultAddress(), isDefaultAddress);
    }

    @Test
    public void TC10_verifyErrorMessageForAllMandatoryFieldsWhenNoDataIsEntered() {

        //Navigate To Website
        DriverFactory.getDriver().navigate().to("https://tutorialsninja.com/demo/");
        //Navigate to Login Page
        LandingPage landingPage = new LandingPage();
        landingPage.navigateToLoginPage();
        //Perform login action
        LoginPage loginPage = new LoginPage();
        loginPage.performLogin("qa.cshah@gmail.com", "qa.cshah123");        //Verify user is on My account page
        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.getPageTitle(), "My Account");
        homePage.navigateToAddressBookPage();
        //Verify user is on Address Book Page
        AddressBookPage addressBookPage = new AddressBookPage();
        Assert.assertEquals(DriverFactory.getDriver().getTitle(), "Address Book");
        Assert.assertEquals(addressBookPage.getSectionHeader(), "Address Book Entries");

        addressBookPage.navigateToNewAddressPage();
        AddAddressPage addAddressPage = new AddAddressPage();
        Assert.assertEquals(addAddressPage.getPageTitle(), "Address Book");
        Assert.assertEquals(addressBookPage.getSectionHeader(), "Add Address");

        addAddressPage.clickContinueButton();

        Assert.assertEquals(addAddressPage.getFirstNameErrMsg(), "First Name must be between 1 and 32 characters!");
        Assert.assertEquals(addAddressPage.getLastNameErrMsg(), "Last Name must be between 1 and 32 characters!");
        Assert.assertEquals(addAddressPage.getAddressLineOneErrMsg(), "Address must be between 3 and 128 characters!");
        Assert.assertEquals(addAddressPage.getCityErrMsg(), "City must be between 2 and 128 characters!");
        Assert.assertEquals(addAddressPage.getPostCodeErrMsg(), "Postcode must be between 2 and 10 characters!");
        Assert.assertEquals(addAddressPage.getStateErrMsg(), "Please select a region / state!");
    }
}
