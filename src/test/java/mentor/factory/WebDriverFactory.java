package mentor.factory;

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
        switch (browser) {
            case "chrome":
                return new ChromeDriver(ChromeDriverOptions.getChromeOptions());
            case "firefox":
                return new FirefoxDriver(FirefoxDriverOptions.getFirefoxOptions());
            case "edge":
                // TODO add EdgeDriverOptions class
                return new EdgeDriver();
            default:
                throw new IllegalStateException("Unexpected browser type: " +  browser);
        }
    }
}
