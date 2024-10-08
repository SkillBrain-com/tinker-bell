package Laur.test;

import Laur.pageObject.CheckBoxPageObject;
import Laur.pageObject.ChromeOptionGenerator;
import Laur.utilities.TakeScreenshotService;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(CheckBoxTest.class);

    private CheckBoxPageObject checkBoxPageObject;
    private WebDriver driver;

    @BeforeTest
    public void initializeDriver() {
        LOGGER.info("Initializing driver...");
        driver = ChromeOptionGenerator.getChromeDriver();
        checkBoxPageObject = new CheckBoxPageObject(driver);
        LOGGER.info("Driver has been initialized.");
    }

    @AfterTest
    public void closeDriver() {
        LOGGER.info("Closing driver...");
        driver.quit();
    }

    @Test
    public void checkBoxTest(){
        LOGGER.info("Landing on checkbox page...");
        driver.get(CheckBoxPageObject.CHECKBOX_PAGE_URL);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/checkbox");
        LOGGER.info("Clicking on Expand button...");
        checkBoxPageObject.getPlusButton().click();
        checkBoxPageObject.getReactButton().click();
        Assert.assertTrue(checkBoxPageObject.getReactCheckbox().isSelected());
        TakeScreenshotService.takeScreenshot(driver);
    }
}
