package mentor.test;

import mentor.pageObject.BrowserWindowPageObject;
import mentor.utilities.TakeScreenshotService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class BrowserWindowTest {

    private ChromeOptions options;
    private WebDriver driver;
    private BrowserWindowPageObject browserWindowPageObject;
    private static final String EXPECTED_URL_NEW_TAB="https://demoqa.com/sample";

    @BeforeTest
    public void initializeDriver() {
        options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        browserWindowPageObject = new BrowserWindowPageObject(driver);
    }


    @AfterTest()
    public void closeDriver() {
        driver.quit();
    }

    @Test(testName = "Open second browser tab and fetch sample message")
    public void openNewWindowTest() {
        browserWindowPageObject.goToBrowserWindowPage();
        browserWindowPageObject.getTabButton().click();
//        TODO - make a reusable method in the BasePage class
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
//        TODO - make this switch to function reusable across all page objects (hint BasePage)
        driver.switchTo().window(childWindow);
        Assert.assertEquals(browserWindowPageObject.getSampleHeading().getText(), "This is a sample page");
        TakeScreenshotService.takeScreenshot(driver);
        Assert.assertEquals(driver.getCurrentUrl(), EXPECTED_URL_NEW_TAB);
        driver.switchTo().window(parentWindow);
        browserWindowPageObject.getHomePageImage().click();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://demoqa.com/"));
        TakeScreenshotService.takeScreenshot(driver);
    }

//    TODO - create test with second NEW WINDOW Button, please take screenshot at certain steps of the test
//    TODO - please create your task on the board!!!!

}
