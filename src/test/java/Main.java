import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args)  {

        WebDriver driver = new ChromeDriver();

        driver.get("https://practicesoftwaretesting.com/");
        driver.manage().window().maximize();

        WebElement inputSearch = driver.findElement(By.xpath("//*[@id=\"search-query\"]"));
        inputSearch.sendKeys("thor");

        inputSearch.sendKeys(Keys.ENTER);

    }
}
