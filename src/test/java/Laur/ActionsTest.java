package Laur;


import Laur.pageObject.ChromeOptionGenerator;
import Laur.pageObject.AlertPageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsTest {

    private ChromeOptions options;
    private WebDriver driver;
    private AlertPageObject alertPageObject;
    private Alert alertWindow;

    @BeforeTest
    public void initializeDriver() {
        driver = ChromeOptionGenerator.getChromeDriver();
        alertPageObject = new AlertPageObject(driver);
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }

    // 1. Mostenire
    // 2. Incapsularea
    // 3. Polimorfism
    // 4. Abstractizare

    @Test
    public void acceptAlertTest() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/alerts");
        alertPageObject.getAlertButton().click();
        alertWindow = driver.switchTo().alert();
        alertWindow.accept();
    }

    @Test
    public void dismissAlertTest() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/alerts");

        alertPageObject.getConfirmButton().click();
        alertWindow = driver.switchTo().alert();
        alertWindow.dismiss();

        String confirmResult = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals(confirmResult, "You selected Cancel");
    }

    @Test
    public void timerAlertTest(){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/alerts");

        alertPageObject.getTimerAlertButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        Alert alertWindow = wait.until(ExpectedConditions.alertIsPresent());
        String expectedText = "This alert appeared after 5 seconds";
        Assert.assertEquals(alertWindow.getText(), expectedText);
        alertWindow.accept();
    }

    @Test
    public void promtAlertTest(){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/alerts");

        alertPageObject.getPromtButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Alert alertWindow = wait.until(ExpectedConditions.alertIsPresent());
        alertWindow.sendKeys("Test");
        alertWindow.accept();

        String confirmText = driver.findElement(By.id("promptResult")).getText();
        Assert.assertEquals(confirmText, "You entered Test");

    }

}