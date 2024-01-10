package org.trycatch.v3;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.trycatch.v3.driver.DriverFactory;
import org.trycatch.v3.pages.*;

public class ForgotPasswordPageTest extends BaseTest {

    @Test
    public void TC06_verifyErrorMessageOnForgotPasswordPageWhenInvalidEmailAddressIsSubmitted() {

        //Navigate To Website
        DriverFactory.getDriver().navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        LandingPage landingPage = new LandingPage();
        landingPage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage();
        loginPage.navigateToForgotPasswordPage();

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
        forgotPasswordPage.enterEmailAddress("abcdef@abcdef.com");
        forgotPasswordPage.clickContinueButton();

        //Get Page title and verify it.
        Assert.assertEquals(forgotPasswordPage.getPageTitle(), "Forgot Your Password?");
        //Get Error message and verify it
        Assert.assertEquals(forgotPasswordPage.getErrorMessage(), "Warning: The E-Mail Address was not found in our records, please try again!");
    }
}
