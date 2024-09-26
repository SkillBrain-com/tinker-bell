package mentor.test;


import mentor.pageObject.AlertPageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AlertTest {

//    TODO  - add logging to all tests
//    TODO - add verification steps to tests
//    TODO - click on last button and assert the text you entered in the alert window is the same as the message next to the button
    public static final Logger LOGGER = LoggerFactory.getLogger(AlertTest.class);

    private ChromeOptions options;
    private WebDriver driver;
    private AlertPageObject alertPageObject;
    private static final String EXPECTED_URL_NEW_TAB = "https://demoqa.com/sample";
    private Alert alertWindow;

    @BeforeTest
    public void initializeTest() {
        LOGGER.info("Initializing driver...");
        options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        alertPageObject = new AlertPageObject(driver);
        LOGGER.info("Driver has been initialized.");
    }


    @AfterTest()
    public void closeDriver() {
        LOGGER.info("Closing driver...");
        driver.quit();
    }

    // 1. Mostenire
    // 2. Incapsularea
    // 3. Polimorfism
    // 4. Abstractizare

    @Test
    public void acceptAlertTest() {
//        TODO - create method to land on alerts page (if not already done)
        driver.get("https://demoqa.com/alerts");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/alerts");
        alertPageObject.getAlertButton().click();
        alertWindow = driver.switchTo().alert();
        alertWindow.accept();
    }

    @Test(testName = "Dismiss delayed alert pop-up")
    public void dismissDelayedAlertTest() {
        LOGGER.info("Landing of alert page...");
        alertPageObject.goToAlertPage();
        LOGGER.info("Switching focus to alert window...");
        alertPageObject.getTimerAlertButton().click();
        LOGGER.info("Clicking on OK button...");

        alertPageObject.setWebDriverWait();
        alertPageObject.getWebDriverWait().until(ExpectedConditions.alertIsPresent());
        try {
            driver.switchTo().alert().accept();
            LOGGER.info("Clicked on OK button.");
        } catch (Exception e) {
            LOGGER.error("Failed to switch focus to alert window.");
        }
    }

    @Test(testName = "Dismiss instant alert pop-up.")
    public void dismissAlertTest() {
//    TODO - defined a constant inside AlertPageObject instead of hard-coding it twice. HINT (use final keyword)
        driver.get("https://demoqa.com/alerts");
        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, "https://demoqa.com/alerts");

        WebElement alertButton = driver.findElement(By.id("confirmButton"));
        alertButton.click();

        alertWindow = driver.switchTo().alert();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        alertWindow.dismiss();
        String confirmResult = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals(confirmResult, "You selected Cancel");
    }


//    TODO -write two more tests for the remaining unused button, please add validation steps


}