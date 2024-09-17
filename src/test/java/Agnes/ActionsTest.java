package Agnes;


import Agnes.config.ChromeOptionsConfig;
import Agnes.pageObject.AlertPageObjectAgnes;
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

import static Agnes.pageObject.AlertPageObjectAgnes.URL_DEMOQA;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class ActionsTest {

    private ChromeOptions options;
    private WebDriver driver;
    private AlertPageObjectAgnes alertPageObject;
    private Alert alertWindow;

    @BeforeTest
    public void initializeDriver() {
//        TODO - define static method that returns a ChromeDriver object.
        // not clear
        options = ChromeOptionsConfig.getChromeOptions();
        driver = new ChromeDriver(options);
        alertPageObject = new AlertPageObjectAgnes(driver);
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
        driver.get("https://demoqa.com/alerts");
        alertPageObject.getAlertButton().click();
        alertWindow = driver.switchTo().alert();
        alertWindow.accept();
    }

    @Test
    public void dismissAlertTest() {
//   - defined a constant inside AlertPageObject instead of hard-coding it twice. HINT (use final keyword)
        //DONE

        driver.get(URL_DEMOQA);
        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, URL_DEMOQA);

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

//   -write two more tests for the remaining unused button, please add validation steps
    //DONE

    @Test
    public void promptAlertTest() {
        driver.get(URL_DEMOQA);
        alertPageObject.getPromtAlertButton().click();
        alertWindow = driver.switchTo().alert();
        alertWindow.sendKeys("Agnes");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        alertWindow.accept();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        String confirmName = driver.findElement(By.id("promptResult")).getText();
        Assert.assertEquals(confirmName,"You entered Agnes");
    }


    @Test
    public void timerAlertButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(URL_DEMOQA);
        alertPageObject.getTimerAlertButton().click();
        wait.until(alertIsPresent());
        alertWindow=driver.switchTo().alert();
        alertWindow.accept();

    }


}
