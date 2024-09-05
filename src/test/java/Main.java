import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Main {

    private WebDriver driver;


    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--window-size=1280,1024");

        driver = new ChromeDriver(options);
        driver.get("https://practicesoftwaretesting.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




    @Test
    public void testAdaugareProduseIncos() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement inputSearch = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search-query\"]")));
        inputSearch.sendKeys("thor");
        inputSearch.sendKeys(Keys.ENTER);

        WebElement produsThor = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt=\"Thor Hammer\"]")));
        produsThor.click();

        WebElement adaugaInCos = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-add-to-cart")));
        int clicksNeeded = 3;
        for (int i = 0; i < clicksNeeded; i++) {
           adaugaInCos.click();
        }

        driver.get("https://practicesoftwaretesting.com/checkout");

        List<WebElement> listaNumeProduse = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        boolean produsInCos = false;
        for (int i =0; i< listaNumeProduse.size() ; i++){
            int randCurent = i +1;
            if(listaNumeProduse.get(i).getText().equals("Thor Hammer ")){
                produsInCos = true;
                WebElement cantitateCos = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[" + randCurent + "]/td[2]/input")));
                Assert.assertEquals(cantitateCos.getAttribute("value"),"3");
                break;
            }
        }
        Assert.assertTrue(produsInCos);

        driver.get("https://practicesoftwaretesting.com/");

        WebElement inputCautare = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search-query\"]")));
        inputCautare.sendKeys("Wood");
        inputCautare.sendKeys(Keys.ENTER);

        WebElement produsSaw = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[2]/h5")));
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);

        fluentWait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        produsSaw = fluentWait.until(webDriver -> webDriver.findElement(By.xpath("//html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[2]/h5")));
        produsSaw.click();

        WebElement plusSaw = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"btn-increase-quantity\"]/fa-icon")));
        int piece = 3;
        for (int i = 1; i<piece; i++){
            plusSaw.click();
        }

        WebElement addToCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-add-to-cart")));
        addToCart.click();

        driver.get("https://practicesoftwaretesting.com/checkout");

        listaNumeProduse = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        produsInCos = false;
        driver.findElement(By.xpath("//span[.='Combination Pliers '] //parent::td //parent::tr //td[2] //child::input")).getText();
        for (int i =0; i< listaNumeProduse.size() ; i++){
            int randCurent = i +1;
            if(listaNumeProduse.get(i).getText().equals("Wood Saw ")){
                produsInCos = true;
                WebElement cantitateCos = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[" + randCurent + "]/td[2]/input")));
                Assert.assertEquals(cantitateCos.getAttribute("value"), String.valueOf(piece));
                break;
            }

        }
        Assert.assertTrue(produsInCos);

    }


    @DataProvider(name = "credentiale")
    public Object[][] credentialeProvider(){
        return new Object[][]{
                {"customer@practicesoftwaretesting.com", "welcome01", "Jane Doe"},
                {"customer2@practicesoftwaretesting.com","welcome01", "Jack Howe"}
        };
    }


    @Test(dataProvider =  "credentiale")
    public void testLogin(String email, String password, String numeComplet) {

        WebDriverWait waitScurt = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebDriverWait waitMediu = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebDriverWait waitLung = new WebDriverWait(driver, Duration.ofSeconds(60));

        driver.get("https://practicesoftwaretesting.com/");
        WebElement signInLink =  waitScurt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-header/nav/div/div/ul/li[4]/a")));
        signInLink.click();
        WebElement emailField =  waitScurt.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"email\"]")));
        emailField.sendKeys(email);
        WebElement passwordField  = waitScurt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password\"]/div/input")));
        passwordField.click();
        passwordField.sendKeys(password);
        WebElement signInButton = waitScurt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/div/div/form/div[3]/input")));
        signInButton.click();


        WebElement accountName =  waitMediu.until(ExpectedConditions.presenceOfElementLocated(By.id("menu")));
        Assert.assertEquals(accountName.getText() , numeComplet);

    }

    @Test
    public void testAsteptarePopUp(){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement inputSearch = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search-query\"]")));
        inputSearch.sendKeys("thor");
        inputSearch.sendKeys(Keys.ENTER);
        WebElement thorHammer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt=\"Thor Hammer\"]")));
        thorHammer.click();

        WebElement addToCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-add-to-cart")));
        addToCart.click();


        WebElement notificareAddCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role=\"alert\"]")));

        Assert.assertEquals(notificareAddCart.getText(), "Product added to shopping cart.");
        wait.until(ExpectedConditions.invisibilityOf(notificareAddCart));

        WebElement cart = driver.findElement(By.xpath("//*[@id=\"lblCartCount\"]"));
        cart.click();


    }


}