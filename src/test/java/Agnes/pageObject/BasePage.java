package Agnes.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    private static final int TIMEOUT= 10;
//    TODO - please make sure all Page objects inherit BasePage (UIPAge, Page, etc.)

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setWebDriverWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        }
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

}