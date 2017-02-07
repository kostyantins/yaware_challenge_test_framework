package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private PropertiesReader() {
    }

    private static final String CONFIG_PROPERTIES = "src//resources/config.properties";

    public static String getProperty(final String propertyName) {

        String propertyValue = null;

        try (final InputStream fileInputStream = new FileInputStream(CONFIG_PROPERTIES)) {

            final Properties property = new Properties();

            property.load(fileInputStream);

            propertyValue = property.getProperty(propertyName);

        } catch (final IOException e) {
            System.out.println("property file is absent");
        }

        return propertyValue;
    }
}
