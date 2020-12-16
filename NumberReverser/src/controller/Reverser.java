package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class Reverser {

    public int reverse(String strNumber) {
        int number = Integer.parseInt(strNumber);

        int count = (number + "").length();
        int reverseNo = 0;
        for (int x = 0; x < count; x++) {
            int result = number % 10;
            number = number / 10;
            reverseNo = Integer.parseInt(reverseNo + "" + result);
        }

        return  reverseNo;
    }


}
