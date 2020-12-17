package com.virtusa.capitalization.controller;

import com.virtusa.capitalization.service.CharacterFinder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Application {


    public static void main(String[] args) {

        try {
            CharacterFinder characterFinder = new CharacterFinder("src\\com\\virtusa\\capitalization\\controller\\TextFile.txt");
            String text = characterFinder.convertToCapital();
            System.out.println(text);

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found  ");

        } catch (IOException ioException) {
            System.out.println("Cant read this File  ");
        }

    }

}
