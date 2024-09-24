package mentor.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class TakeScreenshotService {
    
    
    public static void takeScreenshot(WebDriver driver) {
        String destinationFile = null;
//                                      CAST (TRANSFORMATION)
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        destinationFile = System.getProperty("user.dir")  +"/evidence/Screenshot-" + LocalDateTime.now() + ".png";
        try {
            FileUtils.copyFile(source, new File(destinationFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    
    
    
    
}
