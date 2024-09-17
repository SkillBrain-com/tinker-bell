package Agnes.config;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsConfig {

    private ChromeOptionsConfig() {}


    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        return options;
    }


}
