package Agnes.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserWindowsObject extends BasePage {

    @FindBy(id = "sampleHeading")
    private WebElement sampleHeading;

    @FindBy(id = "tabButton")
    private WebElement tabButton;

    @FindBy(id = "windowButton")
    private WebElement windowButton;

    @FindBy(id = "messageWindowButton")
    private WebElement messageWindowButton;

    @FindBy(xpath = "(//img)[2]")
    private WebElement homePageImage;

    public static final Logger LOGGER = LoggerFactory.getLogger(BrowserWindowsObject.class);

    public static final String BROWSER_WINDOW_URL = "https://demoqa.com/browser-windows";



    public BrowserWindowsObject(WebDriver driver) {
        super(driver);
    }

    public WebElement getHomePageImage() {
        return homePageImage;
    }

    public void goToBrowserWindowPage() {
        LOGGER.info("Hitting the URL: " + BROWSER_WINDOW_URL + ".");
        driver.get(BROWSER_WINDOW_URL);
    }

    public WebElement getTabButton() {
        return tabButton;
    }

    public WebElement getWindowButton() {
        return windowButton;
    }

    public WebElement getMessageWindowButton() {
        return messageWindowButton;
    }

    public WebElement getSampleHeading() {
        return sampleHeading;
    }
}
