package org.trycatch.v3.pages;

import org.trycatch.v3.driver.DriverFactory;

public class BasePage {

    public String getPageTitle() {
        return DriverFactory.getDriver().getTitle();
    }

}
