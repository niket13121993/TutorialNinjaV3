package org.trycatch.v3;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.trycatch.v3.driver.DriverFactory;
import org.trycatch.v3.pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSearchPageTest extends BaseTest{

    @Test
    public void TC11_verifyMatchingProductsAreDisplayedAsPerProvidedSearchCriteria() {

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
        homePage.searchForProduct("MacBook");

        ProductSearchPage productSearchPage = new ProductSearchPage();
        productSearchPage.clickOnListViewIcon();

        List<String> expProductTitles = new ArrayList<>(Arrays.asList("MacBook", "MacBook Air", "MacBook Pro"));
        List<String> expProductPrices = new ArrayList<>(Arrays.asList("$500.00", "$1,000.00", "$2,000.00"));
        List<String> expProductTaxPrices = new ArrayList<>(Arrays.asList("Ex Tax:$500.00", "Ex Tax:$1,000.00", "Ex Tax:$2,000.00"));

        Assert.assertEquals(productSearchPage.getAllProductNames(), expProductTitles);
        Assert.assertEquals(productSearchPage.getAllProductPrices(), expProductPrices);
        Assert.assertEquals(productSearchPage.getAllProductPricesAfterTax(), expProductTaxPrices);
    }
}
