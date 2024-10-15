package ErikH.test;

import ErikH.factory.WebDriverFactoryErik;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class ParanetrizedTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(ParanetrizedTest.class);

    private WebDriver driver;

    @BeforeTest
    public void initializeTest() {
        LOGGER.info("Initializing driver...");
        WebDriverFactoryErik factory = new WebDriverFactoryErik();
        driver = factory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LOGGER.info("Driver has been initialized.");
    }

    @AfterTest()
    public void closeDriver() {
        LOGGER.info("Closing driver...");
        driver.quit();
    }

    @DataProvider(name = "pages")
    public Object[][] pageProvider() {
        return new Object[][] {
                {"forms"},
                {"books"},
                {"elements"}
        };
    }
}
