package ErikH.config;

import org.openqa.selenium.chrome.ChromeOptions;

public  class Options {

    public static ChromeOptions getOptions(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        return options;

    }
}
