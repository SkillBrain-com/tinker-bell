package Laur.test;


import Laur.pageObject.BasePage;
import Laur.pageObject.ChromeOptionGenerator;
import Laur.pageObject.AlertPageObject;
import mentor.utilities.TakeScreenshotService;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsTest extends BasePage {
    public static final Logger LOGGER = LoggerFactory.getLogger(ActionsTest  .class);

    private ChromeOptions options;
    private WebDriver driver;
    private AlertPageObject alertPageObject;
    private Alert alertWindow;

    public ActionsTest(WebDriver driver) {
        super(driver);
    }

    @BeforeTest
    public void initializeDriver() {
        LOGGER.info("Initializing driver...");
        driver = ChromeOptionGenerator.getChromeDriver();
        alertPageObject = new AlertPageObject(driver);
        LOGGER.info("Driver has been initialized.");
    }

    @AfterTest
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
        LOGGER.info("Landing on alert page...");
        driver.get(AlertPageObject.ALERT_PAGE_URL);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/alerts");
        LOGGER.info("Clicking on Accept Alert Button...");
        alertPageObject.getAlertButton().click();
        LOGGER.info("Switching focus to alert window...");
        alertWindow = driver.switchTo().alert();
        alertWindow.accept();
        LOGGER.info("Clicking on OK button...");
    }

    @Test
    public void dismissAlertTest() {
        LOGGER.info("Landing on alert page...");
        driver.get(AlertPageObject.ALERT_PAGE_URL);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/alerts");
        LOGGER.info("Clicking on Dismiss Alert Button...");
        alertPageObject.getConfirmButton().click();
        LOGGER.info("Switching focus to alert window...");
        alertWindow = driver.switchTo().alert();
        alertWindow.dismiss();
        LOGGER.info("Clicking on dismiss button...");
        String confirmResult = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals(confirmResult, "You selected Cancel");
        TakeScreenshotService.takeScreenshot(driver);
    }

    @Test
    public void timerAlertTest(){
        LOGGER.info("Landing on alert page...");
        driver.get(AlertPageObject.ALERT_PAGE_URL);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/alerts");
        LOGGER.info("Clicking on Timer Alert Button...");
        alertPageObject.getTimerAlertButton().click();
        LOGGER.info("Waiting 5 seconds for alert to appear...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        Alert alertWindow = wait.until(ExpectedConditions.alertIsPresent());
        String expectedText = "This alert appeared after 5 seconds";
        Assert.assertEquals(alertWindow.getText(), expectedText);
        LOGGER.info("Clicking on accept button...");
        alertWindow.accept();
        TakeScreenshotService.takeScreenshot(driver);
    }

    @Test
    public void promtAlertTest(){
        LOGGER.info("Landing on alert page...");
        driver.get(AlertPageObject.ALERT_PAGE_URL);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/alerts");
        LOGGER.info("Clicking on Promt Alert Button...");
        alertPageObject.getPromtButton().click();
        LOGGER.info("Waiting for alert to appear...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Alert alertWindow = wait.until(ExpectedConditions.alertIsPresent());
        LOGGER.info("Writting Test text in the pop up...");
        alertWindow.sendKeys("Test");
        TakeScreenshotService.takeScreenshot(driver);
        LOGGER.info("Clicking on accept button...");
        alertWindow.accept();
        String confirmText = driver.findElement(By.id("promptResult")).getText();
        Assert.assertEquals(confirmText, "You entered Test");
        TakeScreenshotService.takeScreenshot(driver);
    }

}