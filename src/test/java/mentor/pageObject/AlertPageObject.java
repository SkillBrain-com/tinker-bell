package mentor.pageObject;

import mentor.test.AlertTest;
import mentor.utilities.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlertPageObject extends BasePage {


    public static final String ALERT_PAGE_URL = PropertyUtils.propertiesLoader().getProperty("alertPageUrl");
    public static final Logger LOGGER = LoggerFactory.getLogger(AlertPageObject.class);

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
        LOGGER.info("Going to " + ALERT_PAGE_URL);
        driver.get(ALERT_PAGE_URL);
    }


    public WebElement getAlertButton() {
        return alertButton;
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }

}

