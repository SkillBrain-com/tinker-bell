package Agnes.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class PropertyUtils {

    public static final Logger LOGGER = LoggerFactory.getLogger(PropertyUtils.class);

    public static Properties propertiesLoader() {
        Properties properties = new Properties();
        String fileLocation = System.getProperty("user.dir") + "/src/test/resources/testConfig.properties";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileLocation))) {
            properties.load(reader);
        } catch (IOException e) {
            LOGGER.error("Failed to load properties file at location:" + fileLocation);
            LOGGER.error(e.getMessage());
            throw new RuntimeException("Failed to load properties file.");
        }
        return properties;
    }


}
