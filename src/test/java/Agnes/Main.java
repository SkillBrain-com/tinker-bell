package Agnes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

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
    public void testAdaugareProduseIncos() throws InterruptedException {

        WebElement inputSearch = driver.findElement(By.xpath("//*[@id=\"search-query\"]"));
        inputSearch.sendKeys("thor");
        inputSearch.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        WebElement produsThor = driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a/div[1]/img"));
        produsThor.click();
        Thread.sleep(2000);

        String expectedTitle = "Thor Hammer";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

        WebElement adaugaInCos = driver.findElement(By.id("btn-add-to-cart"));
        adaugaInCos.click();
        Thread.sleep(2000);
        adaugaInCos.click();
        Thread.sleep(2000);
        adaugaInCos.click();
        Thread.sleep(2000);


        driver.get("https://practicesoftwaretesting.com/checkout");
        Thread.sleep(2000);

        List<WebElement> listaNumeProduse = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        boolean produsInCos = false;
        for (int i =0; i< listaNumeProduse.size() ; i++){
            int randCurent = i +1;
            if(listaNumeProduse.get(i).getText().equals("Thor Hammer ")){
                produsInCos = true;
                WebElement cantitateCos = driver.findElement(By.xpath("//tbody/tr[" + randCurent + "]/td[2]/input"));
                Assert.assertEquals(cantitateCos.getAttribute("value"),"3");
            }

        }
        Assert.assertTrue(produsInCos);

        Thread.sleep(2000);
        driver.get("https://practicesoftwaretesting.com/");

        WebElement inputCautare = driver.findElement(By.xpath("//*[@id=\"search-query\"]"));
        inputCautare.sendKeys("Wood");
        inputCautare.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        WebElement produsSaw = driver.findElement(By.xpath("//html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[2]/h5"));
        produsSaw.click();
        Thread.sleep(2000);

        String expectedTabTitle = "Wood Saw";
        Assert.assertTrue(driver.getTitle().contains(expectedTabTitle));

        WebElement plusSaw = driver.findElement(By.xpath("//*[@id=\"btn-increase-quantity\"]/fa-icon"));
        int piece = 3;
        for (int i = 1; i<piece; i++){
            plusSaw.click();
        }

        WebElement addToCart = driver.findElement(By.id("btn-add-to-cart"));
        addToCart.click();
        Thread.sleep(2000);

        driver.get("https://practicesoftwaretesting.com/checkout");
        Thread.sleep(2000);
        listaNumeProduse = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        produsInCos = false;
        for (int i =0; i< listaNumeProduse.size() ; i++){
            int randCurent = i +1;
            if(listaNumeProduse.get(i).getText().equals("Wood Saw ")){
                produsInCos = true;
                WebElement cantitateCos = driver.findElement(By.xpath("//tbody/tr[" + randCurent + "]/td[2]/input"));
                Assert.assertEquals(cantitateCos.getAttribute("value"), String.valueOf(piece));
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
        WebElement signInLink = driver.findElement(By.xpath("/html/body/app-root/app-header/nav/div/div/ul/li[4]/a"));
        signInLink.click();
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
        WebElement passwordField  = driver.findElement(By.xpath("//*[@id=\"password\"]/div/input"));
        passwordField.click();
        passwordField.sendKeys(password);
        WebElement signInButton = driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/div/div/form/div[3]/input"));
        signInButton.click();


        WebElement accountName =  waitMediu.until(ExpectedConditions.presenceOfElementLocated(By.id("menu")));
        Assert.assertEquals(accountName.getText() , numeComplet);

    }

    @Test
    public void testAsteptarePopUp(){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement inputSearch = driver.findElement(By.xpath("//*[@id=\"search-query\"]"));
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
