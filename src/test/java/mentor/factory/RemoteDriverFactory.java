package mentor.factory;


import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverFactory implements RemoteManager{

    // TODO - make webdriver work on multiple threads (for Cristian)

    @Override
    public RemoteWebDriver getRemoteDriver() {
        // localhost -127.0.0.1
        URL remoteURL = null;
        try {
            remoteURL = new URL("http://192.168.100.90:4444");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        RemoteWebDriver driver = new RemoteWebDriver(remoteURL, new ChromeOptions());
        return driver;
    }
}
