package Agnes.pageObject;

import Agnes.utilities.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlertPageObject extends BasePage{

    public static final String URL_DEMOQA ="https://demoqa.com/alerts";
    public static final String ALERT_PAGE_URL = PropertyUtils.propertiesLoader().getProperty("alertPageUrl");
    public static final Logger LOGGER = LoggerFactory.getLogger(AlertPageObject.class);
//    - define the other two selectors
    //DONE





    @FindBy(id = "alertButton")
    private WebElement alertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmButton;

    @FindBy(id = "promtButton")
    private  WebElement promtButton;

    @FindBy(id = "timerAlertButton")
    private  WebElement timerAlertButton;



    public AlertPageObject(WebDriver driver) {
        super(driver);
    }
    public void goToAlertPage() {
        LOGGER.info("Going to " + ALERT_PAGE_URL);
        driver.get(ALERT_PAGE_URL);
    }

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
