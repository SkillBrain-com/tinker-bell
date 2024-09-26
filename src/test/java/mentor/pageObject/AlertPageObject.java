package mentor.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPageObject extends BasePage {


    public static final String ALERT_PAGE_URL = "https://demoqa.com/alerts";

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;

    public WebElement getTimerAlertButton() {
        return timerAlertButton;
    }

    @FindBy(id = "alertButton")
    private WebElement alertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmButton;

    public AlertPageObject(WebDriver driver) {
        super(driver);
    }

    public void goToAlertPage() {
        driver.get(ALERT_PAGE_URL);
    }


    public WebElement getAlertButton() {
        return alertButton;
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }

}

