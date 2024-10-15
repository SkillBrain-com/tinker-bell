package ErikH.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static ErikH.pageObject.BrowserWindowPageObject.LOGGER;

public abstract class BasePage {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

//    TODO - please make sure all Page objects inherit BasePage (UIPAge, Page, etc.)

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    private static final int TIMEOUT = 10;


    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        setWebDriverWait();
    }

    public void setWebDriverWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        }
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public void switchParentWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        driver.switchTo().window(parentWindow);
    }

    public void switchChildWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        if (windowHandles.size() <= 1) {
            LOGGER.error("There is no child window opened.");
            return;
        }

        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
    }
}


