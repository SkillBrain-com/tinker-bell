package mentor.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPageObject {

//TODO - please extend BasePage and use its constructor to initialize the object (hint Check BrowserWindowPageObject)

    public static final String ALERT_PAGE_URL = "https://demoqa.com/alerts";

    public AlertPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "alertButton")
    private WebElement alertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmButton;


    public WebElement getAlertButton() {
        return alertButton;
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }

}

