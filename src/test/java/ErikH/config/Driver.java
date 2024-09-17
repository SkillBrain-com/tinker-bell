package ErikH.config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static ChromeDriver driver;

    public Driver(ChromeOptions options) {
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/alerts");
    }

    public ChromeDriver getDriver() {
        return driver;
    }

    public void quitDriver() {

        driver.quit();
    }
}