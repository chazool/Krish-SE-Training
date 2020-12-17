package controller;

import java.io.*;

public class Application {
    public static void main(String args[]) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int reversedNo = new Reverser().reverse(bufferedReader.readLine());

            System.out.println(reversedNo);

        } catch (IOException ioException) {
            System.out.println("Key Input Fail" + ioException.getMessage());
        } catch (RuntimeException runtimeException) {
            System.out.println("Key Input Fail" + runtimeException.getMessage());
        }


    }


}
