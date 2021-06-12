package com.aranite.assessment.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class Configuration {

    private final Properties properties = new Properties();
    private static final String CONFIG_FILE = "resources/config.properties";

    static final Logger logger = Logger.getLogger(Configuration.class);

    public Configuration() {
        super();
        BasicConfigurator.configure();
        this.loadProperties();
    }

    /**
     * Loads properties from config.properties.
     */
    private void loadProperties() {
        try (InputStream inputStream = new FileInputStream(CONFIG_FILE);) {

            this.properties.load(inputStream);

        } catch (IOException e) {
            logger.error("Unable to locate configuration file \"" + CONFIG_FILE + "\"." +
                    " Make sure it is in your classpath.");
        }
    }

    public String getProperty(String name, String defaultValue) {
        return this.properties.getProperty(name, defaultValue);
    }
}
