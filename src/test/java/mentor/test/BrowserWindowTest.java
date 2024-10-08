package mentor.test;

import mentor.factory.RemoteDriverFactory;
import mentor.pageObject.BrowserWindowPageObject;
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
import java.util.Iterator;
import java.util.Set;

import static mentor.utilities.TakeScreenshotService.takeScreenshot;
import static org.testng.Assert.assertTrue;

public class BrowserWindowTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(BrowserWindowTest.class);

    private ChromeOptions options;
    private WebDriver driver;
    private BrowserWindowPageObject browserWindowPageObject;
    private static final String EXPECTED_URL_NEW_TAB = "https://demoqa.com/sample";

    @BeforeTest
    public void initializeDriver() {
//        TODO - please please use the WebDriverFactory to create the driver
        LOGGER.info("Initializing driver...");
        driver = new RemoteDriverFactory().getRemoteDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        browserWindowPageObject = new BrowserWindowPageObject(driver);
        LOGGER.info("Driver has been initialized.");
    }


    @AfterTest()
    public void closeDriver() {
        LOGGER.info("Closing driver...");
        driver.quit();
    }

    @Test(testName = "Open second browser tab and fetch sample message")
    public void openNewWindowTest() {
        LOGGER.info("Starting test...");
        browserWindowPageObject.goToBrowserWindowPage();
        browserWindowPageObject.getTabButton().click();
//        TODO - make a reusable method in the BasePage class
        LOGGER.info("Fetching window handles");
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
//        TODO - make this switch to function reusable across all page objects (hint BasePage)
        LOGGER.info("Switching to child window");
        driver.switchTo().window(childWindow);
        browserWindowPageObject.setWebDriverWait();
        WebDriverWait webDriverWait = browserWindowPageObject.getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(browserWindowPageObject.getSampleHeading()));
        Assert.assertEquals(browserWindowPageObject.getSampleHeading().getText(), "This is a sample page");
        takeScreenshot(driver);
        Assert.assertEquals(driver.getCurrentUrl(), EXPECTED_URL_NEW_TAB);
        LOGGER.info("Switching back to parent window");
        driver.switchTo().window(parentWindow);
        browserWindowPageObject.getHomePageImage().click();
        assertTrue(driver.getCurrentUrl().equals("https://demoqa.com/"));
        takeScreenshot(driver);
    }

//    TODO - create test with second NEW WINDOW Button, please take screenshot at certain steps of the test
//    TODO - please create your task on the board!!!!

}
