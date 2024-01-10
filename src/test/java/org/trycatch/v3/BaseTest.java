package org.trycatch.v3;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.trycatch.v3.driver.DriverFactory;

import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    public void initializeTest() {
        DriverFactory.initializeBrowser("Chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void quitTest() {
        DriverFactory.quit();
    }
}
