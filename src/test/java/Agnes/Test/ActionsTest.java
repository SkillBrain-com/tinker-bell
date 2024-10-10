package Agnes.Test;


import Agnes.config.ChromeOptionsConfig;
import Agnes.pageObject.AlertPageObject;
import Agnes.utilities.TakeScreenshotService;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static Agnes.pageObject.AlertPageObject.ALERT_PAGE_URL;
import static Agnes.pageObject.AlertPageObject.URL_DEMOQA;
import static Agnes.utilities.TakeScreenshotService.takeScreenshot;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class ActionsTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(Agnes.Test.ActionsTest.class);
    private ChromeOptions options;
    private WebDriver driver;
    private AlertPageObject alertPageObject;
    private Alert alertWindow;
    //    TODO  - add logging to all tests - DONE
//    TODO - add verification steps to tests - DONE
//    TODO - click on last button and assert the text you entered in the alert window is the same as the message next to the button  - DONE

    @BeforeTest
    public void initializeDriver() {
//        TODO - define static method that returns a ChromeDriver object. -DONE
        LOGGER.info("Init driver....");
        options = ChromeOptionsConfig.getChromeOptions();
        driver = new ChromeDriver(options);
        alertPageObject = new AlertPageObject(driver);
        LOGGER.info("Driver initialized.");
    }

    @AfterTest
    public void closeDriver() {
        LOGGER.info("Driver closed.");
        driver.quit();
    }

    // 1. Mostenire
    // 2. Incapsularea
    // 3. Polimorfism
    // 4. Abstractizare

    @Test
    public void acceptAlertTest() {

        alertPageObject.goToAlertPage();
        Assert.assertEquals(driver.getCurrentUrl(),ALERT_PAGE_URL);
        LOGGER.info("Clicking alert button..");
        alertPageObject.getAlertButton().click();
        LOGGER.info("Switching to alert window...");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        alertWindow = driver.switchTo().alert();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        LOGGER.info("Clicking OK button on alert window");

        alertWindow.accept();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        takeScreenshot(driver);
    }

    @Test
    public void dismissAlertTest() {
//   TODO- defined a constant inside AlertPageObject instead of hard-coding it twice. HINT (use final keyword) - DONE

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        alertPageObject.goToAlertPage();
        Assert.assertEquals(driver.getCurrentUrl(), ALERT_PAGE_URL);

        LOGGER.info("Clicking on Confirm box button...");
        alertPageObject.getConfirmButton().click();
        wait.until(alertIsPresent());
        alertWindow = driver.switchTo().alert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        LOGGER.info("Clicking on dismiss button");
        alertWindow.dismiss();
        String confirmResult = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals(confirmResult, "You selected Cancel");
        TakeScreenshotService.takeScreenshot(driver);
    }

// TODO  -write two more tests for the remaining unused button, please add validation steps - DONE


    @Test
    public void promptAlertTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        alertPageObject.goToAlertPage();
        Assert.assertEquals(driver.getCurrentUrl(), ALERT_PAGE_URL);
        LOGGER.info("Clicking on Prompt box alert button...");
        alertPageObject.getPromtAlertButton().click();
        wait.until(alertIsPresent());
        alertWindow = driver.switchTo().alert();
        LOGGER.info("Entering message in prompt window");
        alertWindow.sendKeys("Agnes");
        LOGGER.info("Closing alert window...");
        alertWindow.accept();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String confirmName = driver.findElement(By.id("promptResult")).getText();
        Assert.assertEquals(confirmName,"You entered Agnes");
        TakeScreenshotService.takeScreenshot(driver);
    }


    @Test
    public void timerAlertButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        alertPageObject.goToAlertPage();
        Assert.assertEquals(driver.getCurrentUrl(), ALERT_PAGE_URL);
        LOGGER.info("Clicking on Timer alert button...");
        alertPageObject.getTimerAlertButton().click();
        wait.until(alertIsPresent());
        alertWindow=driver.switchTo().alert();
        LOGGER.info("Closing Timer alert..");
        alertWindow.accept();
        takeScreenshot(driver);
    }


}
