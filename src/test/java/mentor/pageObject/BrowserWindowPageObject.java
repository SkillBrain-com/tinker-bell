package mentor.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowPageObject extends BasePage {


    public static final String BROWSER_WINDOW_URL = "https://demoqa.com/browser-windows";

    public BrowserWindowPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//img)[2]")
    private WebElement homePageImage;

    public WebElement getHomePageImage() {
        return homePageImage;
    }

    @FindBy(id = "sampleHeading")
    private WebElement sampleHeading;

    @FindBy(id = "tabButton")
    private WebElement tabButton;

    @FindBy(id = "windowButton")
    private WebElement windowButton;

    @FindBy(id = "messageWindowButton")
    private WebElement messageWindowButton;

    public void goToBrowserWindowPage() {
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
