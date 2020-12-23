package com.virtusa.singleton.app;


import com.virtusa.singleton.exception.ConfigFileNotFoundException;
import com.virtusa.singleton.exception.ConfigFileReadWriteException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configure {


    private static Configure propertyFileReader;
    private static String configFilePath = "config.properties";
    private static Properties properties;


    private Configure() {
        if (propertyFileReader != null) {
            throw new RuntimeException("Please use getPropertyFileReader method");
        }
    }

    public static Configure getConfiguration() throws ConfigFileNotFoundException, ConfigFileReadWriteException {

        if (propertyFileReader == null) {
            synchronized (Configure.class) {
                if (propertyFileReader == null) {
                    propertyFileReader = new Configure();
                    //Config file reader
                    try {
                        FileReader fileReader = new FileReader(configFilePath);
                        properties = new Properties();
                        properties.load(fileReader);

                    } catch (FileNotFoundException fileNotFoundException) {
                        throw new ConfigFileNotFoundException("Configuration file is missing", fileNotFoundException);
                    } catch (IOException ioException) {
                        throw new ConfigFileReadWriteException("Can not load Configuration File", ioException);

                    }
                }
            }
        }
        return propertyFileReader;
    }


    public String getDateFormat() throws ConfigFileReadWriteException {

        if (properties != null)
            return properties.getProperty("dateFormat");
        else
            throw new ConfigFileReadWriteException("Can not load Configuration File");

    }


}
