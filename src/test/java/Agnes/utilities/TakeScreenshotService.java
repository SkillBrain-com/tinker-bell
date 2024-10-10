package Agnes.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TakeScreenshotService {

    public static final Logger LOGGER = LoggerFactory.getLogger(TakeScreenshotService.class);
    
    public static void takeScreenshot(WebDriver driver) {
        String destinationFile = null;
//                                      CAST (TRANSFORMATION)
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        //LocalDateTime now = LocalDateTime.now();
        //now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
        destinationFile = System.getProperty("user.dir")  +"/evidence/Screenshot-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss")) + ".png";
        try {
            LOGGER.info("Taking screenshot...");
            FileUtils.copyFile(source, new File(destinationFile));
        } catch (IOException e) {
            LOGGER.error("Something went wrong when taking screenshot." + e.getMessage());
            throw new RuntimeException(e);
        }


    }
    
    
    
    
}