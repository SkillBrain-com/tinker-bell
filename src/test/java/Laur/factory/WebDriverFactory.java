package Laur.factory;

import mentor.enums.WebDrivers;
import mentor.utilities.ChromeDriverOptions;
import mentor.utilities.FirefoxDriverOptions;
import mentor.utilities.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class WebDriverFactory implements DriverManager {


    @Override
    public WebDriver getDriver() {
        Properties properties = PropertyUtils.propertiesLoader();
        String browser = properties.getProperty("browser");
        switch (WebDrivers.valueOf(browser.toUpperCase())) {
            case CHROME:
                return new ChromeDriver(ChromeDriverOptions.getChromeOptions());
            case FIREFOX:
                return new FirefoxDriver(FirefoxDriverOptions.getFirefoxOptions());
            case EDGE:
                // TODO add EdgeDriverOptions class
                return new EdgeDriver();
            default:
                throw new IllegalStateException("Unexpected browser type: " +  browser);
        }
    }
}
