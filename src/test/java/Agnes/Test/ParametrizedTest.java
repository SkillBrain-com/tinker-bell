package Agnes.Test;

import mentor.factory.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParametrizedTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(ParametrizedTest.class);

    private WebDriver driver;

    @BeforeTest
    public void initializeTest() {
        LOGGER.info("Initializing driver...");
        WebDriverFactory factory = new WebDriverFactory();
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

    @Test(dataProvider = "pages")
    public void endpointTest(String page) {
        driver.get("https://demoqa.com/" + page);
        boolean displayed = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']")).isDisplayed();
        Assert.assertTrue(displayed);
    }


}
