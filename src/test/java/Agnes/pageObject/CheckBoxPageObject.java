package Agnes.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckBoxPageObject extends BasePage {

    public static final String CHECKBOX_PAGE_URL = ("https://demoqa.com/checkbox");
    public static final Logger LOGGER = LoggerFactory.getLogger(CheckBoxPageObject.class);

    @FindBy(xpath = "//button[@title='Expand all']")
    private WebElement expandButton;

    @FindBy(xpath = "(//span[@class='rct-checkbox'])[7]")
    private WebElement reactButton;

    @FindBy(xpath = "//label[contains(.,'React')] //input")
    private WebElement reactCheckbox;

    public CheckBoxPageObject(WebDriver driver) {
        super(driver);
    }

    public WebElement getExpandButton() {
        return expandButton;
    }

    public WebElement getReactButton(){
        return reactButton;
    }

    public WebElement getReactCheckbox() {
        return reactCheckbox;
    }

    public void goToCheckboxPage() {
        LOGGER.info("Going to " + CHECKBOX_PAGE_URL);
        driver.get(CHECKBOX_PAGE_URL);
    }





//    TODO - build page object model - DONE
//    TODO - create selectors - DONE
//    TODO - Land of https://demoqa.com/checkbox - DONE
//    TODO - Select React from workspace - DONE
//    TODO - Assert React is selected !! - DONE

}
