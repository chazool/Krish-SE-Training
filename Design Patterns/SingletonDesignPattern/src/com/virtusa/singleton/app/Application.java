package com.chazool.singleton.app;

import com.chazool.singleton.exception.ConfigFileNotFoundException;
import com.chazool.singleton.exception.ConfigFileReadWriteException;

public class Application {

    public static void main(String[] args) {

        String errorMessage =null ;
        try {
            Configure configure = Configure.getConfiguration();
            String dateFormat = configure.getDateFormat();
            System.out.println(dateFormat);

        } catch (ConfigFileNotFoundException configFileNotFoundException) {
            errorMessage = configFileNotFoundException.getMessage();
        } catch (ConfigFileReadWriteException configFileReadWriteException) {
            errorMessage = configFileReadWriteException.getMessage();
        } catch (RuntimeException runtimeException) {
            errorMessage = runtimeException.getMessage();
        } catch (Exception exception) {
            errorMessage = exception.getMessage();
        } finally {
            if (errorMessage != null)
                System.err.println(errorMessage);
        }
    }
}
