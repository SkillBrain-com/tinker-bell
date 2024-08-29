import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Main {

    @Test
    public void testCautare() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--window-size=1280,1024");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://practicesoftwaretesting.com/");

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

        WebElement produsCosCumparaturi = driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/table/tbody/tr/td[1]/span"));
        Assert.assertEquals(produsCosCumparaturi.getText(), "Thor Hammer ");

        WebElement cantitateCos = driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/table/tbody/tr/td[2]/input"));
        Assert.assertEquals(cantitateCos.getAttribute("value"),"3");

        // de adaugat de 3 ori in cos thor hammer
        // de verificat ca este de 3 ori in cos la final


        // de cautat si adaugat 'Wood Saw' in cosul de cumparaturi si facute aceleasi verificari ca la 'Thor Hammer'
    }
}
