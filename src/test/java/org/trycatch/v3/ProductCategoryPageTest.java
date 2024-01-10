package org.trycatch.v3;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.trycatch.v3.driver.DriverFactory;
import org.trycatch.v3.pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductCategoryPageTest extends BaseTest{

    @Test
    public void TC12_verifyRelevantProductAreDisplayedWhenFilterUsingTopMenuCategory() {

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
        homePage.clickMacUnderDesktopsFromTopMenu();

        ProductCategoryPage productCategoryPage = new ProductCategoryPage();
        productCategoryPage.clickOnListViewIcon();

        List<String> expProductTitlesDesktop = new ArrayList<>(Arrays.asList("iMac"));
        List<String> expProductPricesDesktop = new ArrayList<>(Arrays.asList("$100.00"));
        List<String> expProductTaxPricesDesktop = new ArrayList<>(Arrays.asList("Ex Tax:$100.00"));

        Assert.assertEquals(productCategoryPage.getAllProductNames(), expProductTitlesDesktop);
        Assert.assertEquals(productCategoryPage.getAllProductPrices(), expProductPricesDesktop);
        Assert.assertEquals(productCategoryPage.getAllProductPricesAfterTax(), expProductTaxPricesDesktop);

        homePage.clickPhonesAndPdasFromTopMenu();

        List<String> expProductTitlesPhones = new ArrayList<>(Arrays.asList("HTC Touch HD", "iPhone", "Palm Treo Pro"));
        List<String> expProductPricesPhones = new ArrayList<>(Arrays.asList("$100.00", "$101.00", "$279.99"));
        List<String> expProductTaxPricesPhones = new ArrayList<>(Arrays.asList("Ex Tax:$100.00", "Ex Tax:$101.00", "Ex Tax:$279.99"));

        Assert.assertEquals(productCategoryPage.getAllProductNames(), expProductTitlesPhones);
        Assert.assertEquals(productCategoryPage.getAllProductPrices(), expProductPricesPhones);
        Assert.assertEquals(productCategoryPage.getAllProductPricesAfterTax(), expProductTaxPricesPhones);
    }
}
