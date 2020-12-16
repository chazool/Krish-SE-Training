package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String args[]) {

        try {


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int returnNo = new Reverser().reverse(bufferedReader.readLine());

            System.out.println(returnNo);

        } catch (IOException ioException) {
            System.out.println("Key Input Fail" + ioException.getMessage());
        }catch(RuntimeException runtimeException){
            System.out.println("Key Input Fail" + runtimeException.getMessage());
        }


    }


}
