package mentor.test;


import mentor.pageObject.AlertPageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionsTest {

    private ChromeOptions options;
    private WebDriver driver;
    private AlertPageObject alertPageObject;
    private Alert alertWindow;

    @BeforeTest
    public void initializeDriver() {
//        TODO - define static method that returns a ChromeDriver object.
        options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
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
        driver.get("https://demoqa.com/alerts");
        alertPageObject.getAlertButton().click();
        alertWindow = driver.switchTo().alert();
        alertWindow.accept();
    }

    @Test
    public void dismissAlertTest() {
//    TODO - defined a constant inside AlertPageObject instead of hard-coding it twice. HINT (use final keyword)
        driver.get("https://demoqa.com/alerts");
        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, "https://demoqa.com/alerts");

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

//    TODO -write two more tests for the remaining unused button, please add validation steps


}