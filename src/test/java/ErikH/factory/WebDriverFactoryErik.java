package ErikH.factory;

import ErikH.enums.WebDrivers;
import ErikH.utilities.ChromeDriverOptions;
import ErikH.utilities.EdgeDriverOptions;
import ErikH.utilities.FirefoxDriverOptions;
import ErikH.utilities.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

import static ErikH.enums.WebDrivers.*;

public class WebDriverFactoryErik implements DriverManager {
    public static WebDriver createDriver() {
        // return new RemoteDriverFactory().getRemoteDriver();
        WebDriver driver;
        Properties webdriverproperties = PropertyUtils.propertiesLoader();
        if (webdriverproperties.getProperty("browser").contains("remote")) {
            driver = new RemoteDriverFactory().getRemoteDriver();
        } else {
            driver = new WebDriverFactoryErik().getDriver();

        }
        return driver;
    }
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
                return new EdgeDriver(EdgeDriverOptions.getEdgeOptions());
            default:
                throw new IllegalStateException("Unexpected browser type: " + browser);
        }
    }
}
