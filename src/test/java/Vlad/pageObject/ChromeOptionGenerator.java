package Vlad.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeOptionGenerator {

      private static ChromeOptions options;
    private static WebDriver driver;

    public static WebDriver getChromeDriver() {
        if (options == null) {
            options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--disable-search-engine-choice-screen");
            options.addArguments("--start-maximized");
        }

        if (driver == null) {
            driver = new ChromeDriver(options);
            driver.get(AlertPageObject.ALERT_PAGE_URL);
        }

        return driver;
    }
}
