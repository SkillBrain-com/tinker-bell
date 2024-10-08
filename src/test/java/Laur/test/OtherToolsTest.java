package Laur.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OtherToolsTest {

    private WebDriver driver;
    private static final String URL_HOME_PAGE ="https://practicesoftwaretesting.com/";
    private static final String SPECIAL_TOOLS_PAGE ="https://practicesoftwaretesting.com/category/special-tools";


    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--window-size=1280,1024");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://practicesoftwaretesting.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void otherToolsTest() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.equals("https://practicesoftwaretesting.com/"));
        Assert.assertEquals(currentUrl, URL_HOME_PAGE);

        WebElement categories = driver.findElement(By.xpath("//a[@data-test='nav-categories']"));
        categories.click();
        driver.findElement(By.xpath("//a[text()='Special Tools']")).click();
        String specialToolsUrl = driver.getCurrentUrl();
        Assert.assertEquals(specialToolsUrl, SPECIAL_TOOLS_PAGE);


    }


}
