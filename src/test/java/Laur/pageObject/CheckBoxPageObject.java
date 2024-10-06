package Laur.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxPageObject extends BasePage {

    public CheckBoxPageObject(WebDriver driver) {
        super(driver);
    }
    public static final String CHECKBOX_PAGE_URL = "https://demoqa.com/checkbox";

    @FindBy(xpath = "//button[@title='Expand all']")
    private WebElement plusButton;

    @FindBy(xpath = "(//span[@class='rct-checkbox'])[7]")
    private WebElement reactButton;

    @FindBy(xpath = "//label[contains(.,'React')] //input")
    private WebElement reactCheckbox;

    public WebElement getPlusButton() {
        return plusButton;
    }

    public WebElement getReactButton(){
        return reactButton;
    }

    public WebElement getReactCheckbox() {
        return reactCheckbox;
    }

//    TODO - Assert React is selected !!
        // use .isSelected, gasit input in cod pentru asta
}
