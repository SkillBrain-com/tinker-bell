package ErikH.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class AlertPageObject {

//    TODO - define the other two selectors

        public AlertPageObject(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        public static final String ALERT_PAGE = "https://demoqa.com/alerts";


        @FindBy(id = "alertButton")
        private WebElement alertButton;

        @FindBy(id = "confirmButton")
        private WebElement confirmButton;

        @FindBy(id = "timerAlertButton")
        private WebElement timerAlertButton;

        @FindBy(id = "promtButton")
        private WebElement promtButton;

        public WebElement getPromtButton(){
            return promtButton;
        }

        public WebElement getTimerAlertButton(){
             return timerAlertButton;
        }


        public WebElement getAlertButton() {
            return alertButton;
        }

        public WebElement getConfirmButton() {
            return confirmButton;
        }

    }


