package Laur.test;

import Laur.pageObject.BrowserWindowPageObject;
import Laur.pageObject.ChromeOptionGenerator;
import Laur.utilities.TakeScreenshotService;
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

public class BrowserWindowTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(BrowserWindowTest.class);

    private ChromeOptions options;
    private WebDriver driver;
    private BrowserWindowPageObject browserWindowPageObject;
    private static final String EXPECTED_URL_NEW_TAB = "https://demoqa.com/sample";


    @BeforeTest
    public void initializeDriver() {
        LOGGER.info("Initializing driver...");
        driver = ChromeOptionGenerator.getChromeDriver();
        browserWindowPageObject = new BrowserWindowPageObject(driver);
        LOGGER.info("Driver has been initialized.");
    }

    @AfterTest()
    public void closeDriver() {
        LOGGER.info("Closing driver...");
        driver.quit();
    }

    @Test(testName = "Open second browser tab and fetch sample message")
    public void openNewTabTest() {
        LOGGER.info("Starting test...");
        browserWindowPageObject.goToBrowserWindowPage();
        browserWindowPageObject.getTabButton().click();
        LOGGER.info("Fetching window handles");
        LOGGER.info("Switching to child window");
        browserWindowPageObject.setWebDriverWait();
        WebDriverWait webDriverWait = browserWindowPageObject.getWebDriverWait();
        browserWindowPageObject.switchToChildWindow();
        webDriverWait.until(ExpectedConditions.visibilityOf(browserWindowPageObject.getSampleHeading()));
        Assert.assertEquals(browserWindowPageObject.getSampleHeading().getText(), "This is a sample page");
        TakeScreenshotService.takeScreenshot(driver);
        Assert.assertEquals(driver.getCurrentUrl(), EXPECTED_URL_NEW_TAB);
        LOGGER.info("Switching back to parent window");
        browserWindowPageObject.switchToParentWindow();
        browserWindowPageObject.getHomePageImage().click();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://demoqa.com/"));
        TakeScreenshotService.takeScreenshot(driver);
    }

        @Test(testName = "Open third browser tab and fetch sample message")
        public void open2ndNewTabTest() {
        LOGGER.info("Starting test...");
        browserWindowPageObject.goToBrowserWindowPage();
        browserWindowPageObject.getTabButton().click();
        LOGGER.info("Fetching window handles");
        LOGGER.info("Switching to child window");
        browserWindowPageObject.setWebDriverWait();
        WebDriverWait webDriverWait = browserWindowPageObject.getWebDriverWait();
        browserWindowPageObject.switchToChildWindow();
        webDriverWait.until(ExpectedConditions.visibilityOf(browserWindowPageObject.getSampleHeading()));
        Assert.assertEquals(browserWindowPageObject.getSampleHeading().getText(), "This is a sample page");
        TakeScreenshotService.takeScreenshot(driver);
        Assert.assertEquals(driver.getCurrentUrl(), EXPECTED_URL_NEW_TAB);
        LOGGER.info("Switching back to parent window");
        browserWindowPageObject.switchToParentWindow();
        LOGGER.info("Switching to 2nd child window");
        browserWindowPageObject.setWebDriverWait();
        WebDriverWait webDriverWait2 = browserWindowPageObject.getWebDriverWait();
        browserWindowPageObject.switchToChildWindow();
        webDriverWait2.until(ExpectedConditions.visibilityOf(browserWindowPageObject.getSampleHeading()));
        Assert.assertEquals(browserWindowPageObject.getSampleHeading().getText(), "This is a sample page");
        TakeScreenshotService.takeScreenshot(driver);
        Assert.assertEquals(driver.getCurrentUrl(), EXPECTED_URL_NEW_TAB);
        LOGGER.info("Switching back to parent window");
        browserWindowPageObject.switchToParentWindow();
        browserWindowPageObject.getHomePageImage().click();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://demoqa.com/"));
        TakeScreenshotService.takeScreenshot(driver);
    }
}
