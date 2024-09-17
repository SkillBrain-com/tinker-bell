package ErikH.config;

import ErikH.pageObject.AlertPageObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static ChromeDriver driver;

    public void getAlertPage(){
        driver.get(AlertPageObject.ALERT_PAGE);
    }

    public Driver(ChromeOptions options) {
        driver = new ChromeDriver(options);
    }

    public ChromeDriver getDriver() {
        return driver;
    }

    public void quitDriver() {

        driver.quit();
    }
}