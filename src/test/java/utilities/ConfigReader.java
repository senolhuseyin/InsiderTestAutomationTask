package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {

        final String CONFIGURATION_PROPERTIES_FILE_PATH = "src/configuration.properties";

        try {
            //Read the configuration.properties file
            FileInputStream fis = new FileInputStream(CONFIGURATION_PROPERTIES_FILE_PATH);
            properties = new Properties();

            //Load the information in the configuration.properties file to FileInputStream object
            properties.load(fis);
        } catch (IOException e) {
            //Print on which line the error is
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        //Return the value of the key which sent from the test class
        return properties.getProperty(key);
    }
}
