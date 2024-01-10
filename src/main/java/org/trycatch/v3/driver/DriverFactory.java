package org.trycatch.v3.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    static WebDriver driver;
    public static void initializeBrowser(String browserName) {


        if(browserName.equalsIgnoreCase("CHROME")) {
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("FIREFOX")) {
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("EDGE")) {
            driver = new EdgeDriver();
        }
        else {
            throw new IllegalStateException("Unsupported browser provided : "+browserName);
        }
    }

    public static WebDriver getDriver() {

        return driver;
    }

    public static void quit() {

        getDriver().quit();
    }
}
