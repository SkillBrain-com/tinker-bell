package mentor.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface DriverManager {

    WebDriver getDriver();
}
