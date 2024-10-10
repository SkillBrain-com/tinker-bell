package Agnes.Test;

import Agnes.factory.RemoteDriverFactory;
import Agnes.factory.WebDriverFactory;
import Agnes.pageObject.BrowserWindowsObject;
import Agnes.pageObject.CheckBoxPageObject;
import Agnes.utilities.PropertyUtils;
import Agnes.utilities.TakeScreenshotService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Properties;

public class CheckBoxTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(Agnes.Test.CheckBoxTest.class);

    private ChromeOptions options;
    private WebDriver driver;
    private CheckBoxPageObject checkBoxPageObject;

    @BeforeTest
    public void initializeDriver() {

        LOGGER.info("Initializing driver...");
        Properties properties = PropertyUtils.propertiesLoader();
        if (properties.getProperty("browser").contains("remote")){
            driver=new RemoteDriverFactory().getRemoteDriver();
        }
        else{
            driver = new WebDriverFactory().getDriver();
        }
        //driver = new RemoteDriverFactory().getRemoteDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        checkBoxPageObject = new CheckBoxPageObject(driver);
        LOGGER.info("Driver has been initialized.");
    }

    @AfterTest
    public void closeDriver() {
        LOGGER.info("Closing driver...");
        driver.quit();
    }

    @Test(testName = "Check React checkbox")
    public void reactCheckboxTest() {
        LOGGER.info("Starting test...");
        checkBoxPageObject.goToCheckboxPage();
        checkBoxPageObject.setWebDriverWait();
        LOGGER.info("Expanding menu...");
        checkBoxPageObject.getExpandButton().click();
        checkBoxPageObject.setWebDriverWait();
        LOGGER.info("Checking React button...");
        checkBoxPageObject.getReactButton().click();
        Assert.assertTrue(checkBoxPageObject.getReactCheckbox().isSelected());
        TakeScreenshotService.takeScreenshot(driver);

    }
}
