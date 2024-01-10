package org.trycatch.v3.pages;

import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.trycatch.v3.driver.DriverFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryPage extends BasePage{

    By listViewIcon = By.id("list-view");
    By allProductRows = By.xpath("//div[contains(@class,'product-list')]");
    public void clickOnListViewIcon() {
        DriverFactory.getDriver().findElement(listViewIcon).click();
    }

    public List<String> getAllProductNames() {
        List<String> productNames = new ArrayList<>();
        DriverFactory.getDriver().findElements(allProductRows)
                .forEach(x -> {
                    String productName = x.findElement(By.xpath(".//h4")).getText();
                    productNames.add(productName);
                });
        return productNames;
    }

    public List<String> getAllProductPrices() {
        List<String> productPrices = new ArrayList<>();
        DriverFactory.getDriver().findElements(allProductRows)
                .forEach(x -> {
                    String productName = Jsoup.parse(x.findElement(By.xpath(".//p[@class='price']")).getAttribute("outerHTML")).selectFirst("p").ownText();
                    productPrices.add(productName);
                });
        return productPrices;
    }

    public List<String> getAllProductPricesAfterTax() {
        List<String> productPricesAfterTax = new ArrayList<>();
        DriverFactory.getDriver().findElements(allProductRows)
                .forEach(x -> {
                    String productName = x.findElement(By.xpath(".//span[@class='price-tax']")).getText();
                    productPricesAfterTax.add(productName);
                });
        return productPricesAfterTax;
    }
}
