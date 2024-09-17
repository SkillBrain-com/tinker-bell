package ErikH.config;

import org.openqa.selenium.chrome.ChromeOptions;

public  class Options {

    private static ChromeOptions options;

    public Options() {
        options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--start-maximized");
    }

    public ChromeOptions getOptions() {
        return options;
    }
}
