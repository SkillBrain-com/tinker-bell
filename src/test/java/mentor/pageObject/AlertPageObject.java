package mentor.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPageObject {

//    TODO - define the other two selectors

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
