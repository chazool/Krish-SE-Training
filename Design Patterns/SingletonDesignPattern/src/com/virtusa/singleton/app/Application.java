package com.virtusa.singleton.app;

public class Application {

    public static void main(String[] args) {


        try {

            Configure configure = Configure.getConfiguration();
            String dateFormat = configure.getDateFormat();

            System.out.println(dateFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
