package Laur.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPageObject extends BasePage{

    public static final String ALERT_PAGE_URL = "https://demoqa.com/alerts";

    public AlertPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement alertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmButton;

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;

    @FindBy(id = "promtButton")
    private WebElement promtButton;

    public WebElement getAlertButton() {
        return alertButton;
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }

    public WebElement getTimerAlertButton(){
        return timerAlertButton;
    }

    public WebElement getPromtButton(){
        return promtButton;
    }
}

