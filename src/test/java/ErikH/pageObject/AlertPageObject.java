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


        public static class Options {

            private ChromeOptions options;

            public Options() {
                options = new ChromeOptions();
                options.addArguments("--incognito");
                options.addArguments("--disable-search-engine-choice-screen");
                options.addArguments("--start-maximized");
            }

            public ChromeOptions getOptions() {
                return options;
            }
        }

        public static class Driver {
            private ChromeDriver driver;

            public Driver(ChromeOptions options) {
                driver = new ChromeDriver(options);
                driver.get("https://demoqa.com/alerts");
            }

            public ChromeDriver getDriver() {
                return driver;
            }

            public void quitDriver() {

                driver.quit();
            }
        }
    }


