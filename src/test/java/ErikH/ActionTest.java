package ErikH;


import ErikH.config.Driver;
import ErikH.config.Options;
import ErikH.pageObject.AlertPageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionTest {

    private Options options;
    private Driver driver;
    private AlertPageObject alertPageObject;
    private Alert alertWindow;


    @BeforeTest
    public void initializeDriver() {
        options = new Options();
        driver = new Driver(options.getOptions());
        alertPageObject = new AlertPageObject(driver.getDriver());
    }

    @AfterTest
    public void closeDriver() {
        driver.quitDriver();
    }


    @Test
    public void acceptAlertTest() {
        alertPageObject.getAlertButton().click();
        alertWindow = driver.getDriver().switchTo().alert();
        alertWindow.accept();
    }

    @Test
    public void dismissAlertTest() {
//    TODO - defined a constant inside AlertPageObject instead of hard-coding it twice. HINT (use final keyword)

        String currentUrl = driver.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/alerts");
        alertPageObject.getConfirmButton().click();
        alertWindow = driver.getDriver().switchTo().alert();
        alertWindow.dismiss();
        String confirmResult = driver.getDriver().findElement(By.id("confirmResult")).getText();
        Assert.assertEquals(confirmResult, "You selected Cancel");

    }
        @Test

        public void timerAlert(){
            driver.getDriver();
            alertPageObject.getTimerAlertButton().click();
            WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            alertWindow = driver.getDriver().switchTo().alert();
            String alertText = alertWindow.getText();
            Assert.assertEquals(alertText, "This alert appeared after 5 seconds");
            alertWindow.accept();
    }

    @Test

    public void promptBox(){
        alertPageObject.getPromtButton().click();
        alertWindow = driver.getDriver().switchTo().alert();
        String alertText = alertWindow.getText();
        Assert.assertEquals(alertText, "Please enter your name");
        alertWindow.sendKeys("Erik Hutyra");
        alertWindow.accept();



    }


}
