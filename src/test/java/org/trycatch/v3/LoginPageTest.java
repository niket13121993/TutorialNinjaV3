package org.trycatch.v3;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.trycatch.v3.driver.DriverFactory;
import org.trycatch.v3.pages.*;

public class LoginPageTest extends BaseTest {


    @Test
    public void TC01_verifyUserIsRedirectedToHomePageOnLoginUsingValidUsernameAndPassword() {

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
    }

    @Test
    public void TC02_verifyUserRemainsOnLoginPageOnLoginUsingValidUsernameAndInvalidPassword(){

        //Navigate To Website
        DriverFactory.getDriver().navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        LandingPage landingPage = new LandingPage();
        landingPage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage();
        loginPage.performLogin("qa.cshah@gmail.com", "qa.cshah1234");
        //Get Page title and verify it.
        Assert.assertEquals(loginPage.getPageTitle(), "Account Login");
        //Get error message for invalid credentials and verify it.
        Assert.assertEquals(loginPage.getErrorMessage(), "Warning: No match for E-Mail Address and/or Password.");
    }
    @Test
    public void TC03_verifyUserRemainsOnLoginPageOnLoginUsingBlankUsernameAndPassword() {

        //Navigate To Website
        DriverFactory.getDriver().navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        LandingPage landingPage = new LandingPage();
        landingPage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage();
        loginPage.performLogin("", "");
        //Get Page title and verify it.
        Assert.assertEquals(loginPage.getPageTitle(), "Account Login");
        //Get error message for invalid credentials and verify it.
        Assert.assertEquals(loginPage.getErrorMessage(), "Warning: No match for E-Mail Address and/or Password.");
    }
    @Test
    public void TC04_verifyUserRemainsOnLoginPageOnLoginUsingValidUsernameAndBlankPassword() {

        //Navigate To Website
        DriverFactory.getDriver().navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        LandingPage landingPage = new LandingPage();
        landingPage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage();
        loginPage.performLogin("qa.cshah@gmail.com", "");
        //Get Page title and verify it.
        Assert.assertEquals(loginPage.getPageTitle(), "Account Login");
        //Get error message for invalid credentials and verify it.
        Assert.assertEquals(loginPage.getErrorMessage(), "Warning: No match for E-Mail Address and/or Password.");
    }
    @Test
    public void TC05_verifyUserIsNavigatedToForgotPasswordPageOnClickingForgotPasswordLink() {

        //Navigate To Website
        DriverFactory.getDriver().navigate().to("https://tutorialsninja.com/demo/");
        //Click on My account Link
        LandingPage landingPage = new LandingPage();
        landingPage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage();
        loginPage.navigateToForgotPasswordPage();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

        Assert.assertEquals(forgotPasswordPage.getPageTitle(), "Forgot Your Password?", "Title did not match");
    }
}
