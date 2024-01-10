package org.trycatch.v3;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.trycatch.v3.driver.DriverFactory;
import org.trycatch.v3.pages.*;

public class AddressBookPageTest extends BaseTest {

    @Test
    public void TC07_verifyUserIsNavigatedToAddAddressPageOnClickingAddAddressButton() {

        //Navigate To Website
        DriverFactory.getDriver().navigate().to("https://tutorialsninja.com/demo/");
        //Navigate to Login Page
        LandingPage landingPage = new LandingPage();
        landingPage.navigateToLoginPage();
        //Perform login action
        LoginPage loginPage = new LoginPage();
        loginPage.performLogin("qa.cshah@gmail.com", "qa.cshah123");
        //Verify user is on My account page
        Assert.assertEquals(loginPage.getPageTitle(), "My Account");
        HomePage homePage = new HomePage();
        homePage.navigateToAddressBookPage();
        //Verify user is on Address Book Page
        AddressBookPage addressBookPage = new AddressBookPage();
        Assert.assertEquals(addressBookPage.getPageTitle(), "Address Book");
        Assert.assertEquals(addressBookPage.getSectionHeader(), "Address Book Entries");

        addressBookPage.navigateToNewAddressPage();
        AddAddressPage addAddressPage = new AddAddressPage();
        Assert.assertEquals(addAddressPage.getPageTitle(), "Address Book");
        Assert.assertEquals(addressBookPage.getSectionHeader(), "Add Address");
    }

}
