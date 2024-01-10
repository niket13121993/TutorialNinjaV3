package org.trycatch.self.practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.trycatch.v3.driver.DriverFactory;

import javax.security.auth.kerberos.KeyTab;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.NoSuchElementException;

public class PracticeCode {

    public void workingWithDropDownControl() throws InterruptedException {
        WebDriver browser = new ChromeDriver();
        DriverFactory.getBrowser().manage().window().maximize();
        DriverFactory.getBrowser().navigate().to("https://omayo.blogspot.com/");

        //Selecting drop down value by index number.
        WebElement dropDownElement = DriverFactory.getBrowser().findElement(By.id("multiselect1"));
        Select dropDownSelect = new Select(dropDownElement);
        dropDownSelect.selectByIndex(0);
        dropDownSelect.selectByIndex(3);

        //Selecting drop down value by visible text
        dropDownSelect.selectByVisibleText("Swift");

        //Selecting drop down value by "Value" attribute
        dropDownSelect.selectByValue("Hyundaix");

        //Getting selected option from drop down
        dropDownSelect.getFirstSelectedOption().getAttribute("name");

        //Getting all selected options from drop down and printing them
        List<WebElement> allSelectedOptions =  dropDownSelect.getAllSelectedOptions();
        allSelectedOptions.forEach(x-> System.out.println(x.getText()));

        //Deselecting all option from drop down field
        dropDownSelect.deselectAll();

        DriverFactory.getBrowser().quit();
    }
    public void workingWithStringFormat() {
        String user = "Chintan;";
        double salary = 1000000;
        int id = 1122;
        //String concat
        String s1 = "Welcome " + user + ", your salary is " + salary + ", your employee ID is " + id;

        //String format
        String s = "Welcome %-20s, your salary is %20.2f, your employee ID is %7d";
        String formatted = String.format(s, user, salary, id);

        System.out.println(formatted);
    }
    public void workingWithKeyboardCommands() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://tutorialsninja.com/demo/");

        //Sending multiple KeyStroke as part of input.
        WebElement searchBar = driver.findElement(By.name("search"));
        searchBar.sendKeys(Keys.chord(Keys.LEFT_SHIFT, "MacBook"));

        //Sending single KeyStroke as part of input
        searchBar.sendKeys(Keys.ENTER);
    }
    public void workingWithInputField() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://omayo.blogspot.com/");

        //Getting text from input field
        driver.findElement(By.name("fname")).getAttribute("value");

        //Clearing existing text from input field
        driver.findElement(By.name("fname")).clear();

        //Sending text to input field
        driver.findElement(By.name("fname")).sendKeys("This is input by selenium command");
    }
    public void workingWithLabelsOrStaticText() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://omayo.blogspot.com/");

        //Get text value of an element.
        System.out.println(driver.findElement(By.id("selenium143")).getText());

        //Get any Attribute value of an element
        System.out.println(driver.findElement(By.id("selenium143")).getAttribute("href"));
    }
    public void workingWithTimeouts() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Default timeout settings
        System.out.println(driver.manage().timeouts().getScriptTimeout());
        System.out.println(driver.manage().timeouts().getPageLoadTimeout());
        System.out.println(driver.manage().timeouts().getImplicitWaitTimeout());

        //Set Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Initialize Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Explicit Wait - JQuery
        String jQueryActiveScript = "return jQuery.active == 0";
        wait.until(ExpectedConditions.jsReturnsValue(jQueryActiveScript));
        new Select(driver.findElement(By.id("country"))).selectByVisibleText("India");

        //Explicit Wait - Element Visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hiddenInput")));

        //Initialize Fluent Wait
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hiddenInput")));
    }

    @Test
    public void workingWithAsserts() {

        //Assert - primitive data type
        Assert.assertEquals(1, "1");
        Assert.assertEquals(1, 1);
        Assert.assertEquals('A', "A");

        //Assert boolean condition
        Assert.assertTrue(2 > 3);
        Assert.assertFalse(2 > 3);

        //Assert with failure message
        Assert.assertTrue(2 > 3, "Boolean condition is false");

        //Assert - arrays without order
        String[] namesArray = {"Chintan", "Vishal"};
        String[] names2Array = {"Vishal", "Chintan"};
        Assert.assertEqualsNoOrder(namesArray, names2Array);

        //Assert - lists without order
        List<String> names = new ArrayList<>();
        names.add("Chintan");
        names.add("Vishal");
        List<String> names2 = new ArrayList<>();
        names2.add("Vishal");
        names2.add("Chintan");
        Assert.assertEqualsNoOrder(names, names2);
    }
    public void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void workingWithAlerts() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.navigate().to(PracticeCode.class.getClassLoader().getResource("TrainingSite/Controls.html"));

        //Getting text of alert
        driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        delay(3000);
        alert.accept();

        //Accepting alert
        driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
        alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        delay(3000);
        alert.accept();
        System.out.println(driver.findElement(By.id("alertMsg")).getText());

        //Rejecting alert
        driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
        alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        delay(3000);
        alert.dismiss();
        System.out.println(driver.findElement(By.id("alertMsg")).getText());

        //Sending text to alert dialog
        driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
        Alert alert2 = driver.switchTo().alert();
        delay(3000);
        alert2.sendKeys("Sending text from code");
        delay(3000);
        alert2.accept();
    }
    @Test
    public void workingWithIFrames() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.navigate().to(PracticeCode.class.getClassLoader().getResource("TrainingSite/Controls.html"));

        //Switch by Id or name
        driver.switchTo().frame("iFrame1");

        //Working with elements inside iFrame
        driver.findElement(By.id("iFrame1Input")).sendKeys("Inside iFrame 1");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();;
        System.out.println(driver.findElement(By.id("Frame_MsgBox")).getText());

        //Switching back to default DOM
        driver.switchTo().defaultContent();

        //Working with iFrames inside Iframe
        driver.switchTo().frame("iFrame2");
        driver.switchTo().frame("iFrame2_1");
        driver.findElement(By.id("iFrame2_1_Input")).sendKeys("Inside iFrame 2.1");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();;
        System.out.println(driver.findElement(By.id("Frame_MsgBox")).getText());

        //Switching to parent iFrame
        driver.switchTo().parentFrame();
        driver.findElement(By.id("iFrame2_Input")).sendKeys("Inside iFrame 2");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();;
        System.out.println(driver.findElement(By.id("Frame_MsgBox")).getText());
    }
    @Test
    public void workingWithFileUploads() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.navigate().to(PracticeCode.class.getClassLoader().getResource("TrainingSite/FileUploads.html"));
        //file:///C:/Users/ADMIN/IdeaProjects/JavaTraining/Batch2_TutorialNinja/src/test/resources/TrainingSite/Controls.html
        System.out.println(PracticeCode.class.getClassLoader().getResource("TrainingSite/FileUploads.html"));
        String filePath1 = new File("src/test/resources/FileUploadTestData/A.docx").getAbsolutePath();
        String filePath2 = new File("src/test/resources/FileUploadTestData/B.docx").getAbsolutePath();
        String filePath3 = new File("src/test/resources/FileUploadTestData/C.docx").getAbsolutePath();

        String filePath4 = new File("src/test/resources/TrainingSite/FileUploads.html").getAbsolutePath();


//        System.out.println(filePath1);
//        System.out.println(filePath2);
        System.out.println(filePath4);

//        Uploading single file via SendKeys to standard browse control.
        driver.findElement(By.id("file-input")).sendKeys(filePath1);
        delay(3000);
        driver.findElement(By.xpath("//button[text()='Upload']")).click();
        delay(3000);
        List<WebElement> fileEntries = driver.findElements(By.xpath("//tbody[@id='file-list']/tr/td[1]"));
        //printFileTable(fileEntries);

        System.out.println("Total files uploaded: "+ fileEntries.size());
        for (WebElement x : fileEntries) {
            System.out.println("File name: "+x.getText());
        }

        delay(3000);

        //Uploading multiple files via SendKeys to standard browse control.
        driver.navigate().refresh();
        String formattedFileText = filePath1+"\n"+filePath2+"\n"+filePath3;
        delay(3000);
        driver.findElement(By.id("file-input")).sendKeys(formattedFileText);
        driver.findElement(By.xpath("//button[text()='Upload']")).click();
        delay(3000);
        List<WebElement> fileEntries2 = driver.findElements(By.xpath("//tbody[@id='file-list']/tr/td[1]"));
        printFileTable(fileEntries2);
        delay(3000);

        //Single File upload - using AutoIt - Static file path
        driver.navigate().refresh();
        driver.findElement(By.id("dragSection")).click();
        delay(3000);
        String[] command1 = new String[] {"src/test/resources/AutoItCode/FileUploadStaticPath.exe"};
        runExecutableFile(command1);
        List<WebElement> fileEntries3 = driver.findElements(By.xpath("//tbody[@id='file-list']/tr/td[1]"));
        printFileTable(fileEntries3);
        delay(3000);

        //Single File upload - using AutoIt - Dynamic file path
        driver.navigate().refresh();
        driver.findElement(By.id("dragSection")).click();
        delay(3000);
        String[] command2 = new String[] {"src/test/resources/AutoItCode/FileUploadDynamicPath.exe", filePath1};
        runExecutableFile(command2);
        List<WebElement> fileEntries4 = driver.findElements(By.xpath("//tbody[@id='file-list']/tr/td[1]"));
        printFileTable(fileEntries4);
        delay(3000);

        //Multiple File upload - using AutoIt - Dynamic file path
        driver.navigate().refresh();
        driver.findElement(By.id("dragSection")).click();
        delay(3000);
        String[] command3 = new String[] {"src/test/resources/AutoItCode/MultipleFileUploadDynamicPath.exe", "3", filePath1, filePath2, filePath3};
        runExecutableFile(command3);
        List<WebElement> fileEntries5 = driver.findElements(By.xpath("//tbody[@id='file-list']/tr/td[1]"));
        printFileTable(fileEntries5);
        delay(3000);
//
        //File upload by JavaScript
//        driver.navigate().refresh();
//        WebElement hiddenInput = driver.findElement(By.id("file-input-drag"));
//        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
//        delay(3000);
//        jsDriver.executeScript("arguments[0].style.display = 'block';", hiddenInput);
//        delay(3000);
//        hiddenInput.sendKeys(filePath1+"\n"+filePath2+"\n"+filePath3);
//        delay(3000);
//        jsDriver.executeScript("arguments[0].style.display = 'none';", hiddenInput);
//        delay(3000);
//        List<WebElement> fileEntries6 = driver.findElements(By.xpath("//tbody[@id='file-list']/tr/td[1]"));
//        printFileTable(fileEntries6);
//        delay(3000);
    }
    private void runExecutableFile(String[] command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void printFileTable(List<WebElement> fileEntries) {
        System.out.println("Total files uploaded: "+ fileEntries.size());
        for (WebElement fileEntry : fileEntries) {
            System.out.println("File name: "+fileEntry.getText());
        }
    }
    @Test
    public void workingWithWindows() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.navigate().to(PracticeCode.class.getClassLoader().getResource("TrainingSite/Controls.html"));

        //Print current window handle
        String currentWindowHandle = driver.getWindowHandle();
        System.out.println(currentWindowHandle);
        System.out.println("#########################");

        //Click all the links to open multiple windows
        driver.findElement(By.id("googleLink")).click();
        delay(3000);
        driver.findElement(By.id("tutorialNinjaLink")).click();
        delay(3000);
        driver.findElement(By.id("orangeHrmLink")).click();
        delay(3000);
//
        //Print all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.forEach(x -> System.out.println(x));
//
        //Switch to OrangeHRM window
        for (String x : windowHandles) {
            driver.switchTo().window(x);
            if(driver.getTitle().equalsIgnoreCase("OrangeHRM")) {
                break;
            }
        }

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        delay(3000);

        //Switch to Google window
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if(driver.getCurrentUrl().equalsIgnoreCase("https://www.google.com/")) {
                break;
            }
        }
        driver.findElement(By.name("q")).sendKeys("Hello Google");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        delay(3000);;

        driver.close();
    }
    @Test
    public void workingWithActionsClass() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.navigate().to(PracticeCode.class.getClassLoader().getResource("TrainingSite/Controls.html"));

        WebElement src = driver.findElement(By.id("dragtarget"));
        WebElement dest = driver.findElement(By.xpath(("//p[@id='demo']/following-sibling::div[@class='droptarget col-sm-3']")));
        delay(3000);
        Actions actions = new Actions(driver);
        actions.scrollToElement(src).scrollByAmount(0,200).build().perform();

        delay(3000);
        actions.dragAndDrop(src, dest).perform();
        delay(3000);
        actions.contextClick(dest).perform();

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            delay(3000);

            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            delay(3000);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            delay(3000);

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void workingWithActionsContextClick() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickEle).perform();



    }
}
