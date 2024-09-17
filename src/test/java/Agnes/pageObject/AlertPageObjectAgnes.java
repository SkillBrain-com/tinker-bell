package Agnes.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPageObjectAgnes {

    public static final String URL_DEMOQA ="https://demoqa.com/alerts";
//    - define the other two selectors
    //DONE


    public AlertPageObjectAgnes(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "alertButton")
    private WebElement alertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmButton;

    @FindBy(id = "promtButton")
    private  WebElement promtButton;

    @FindBy(id = "timerAlertButton")
    private  WebElement timerAlertButton;


    public WebElement getAlertButton() {
        return alertButton;
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }

    public WebElement getPromtAlertButton() {
        return promtButton;
    }

    public WebElement getTimerAlertButton() {
        return timerAlertButton;
    }
}
