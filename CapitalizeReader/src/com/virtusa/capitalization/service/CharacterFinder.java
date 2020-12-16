package com.virtusa.capitalization.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CharacterFinder implements EnglishCharacter {

    public CharacterFinder(String filePath) throws FileNotFoundException {
        this.fileReader = new FileReader(filePath);
    }

    private FileReader fileReader;

    public String convertToCapital() throws IOException {


        UppercaseReader uppercaseReader = new UppercaseReader(fileReader);

        String fullTextContent = "";
        String textLine;
        while ((textLine = uppercaseReader.readLine()) != null) {
            fullTextContent = fullTextContent + "\n" + textLine;
        }

        fileReader.close();
        uppercaseReader.close();
        return fullTextContent;
    }

    @Override
    public char[] getCapitalLatter() throws IOException {

        char[] capitalLaterArray = new char[0];

        int readingValue;

        while ((readingValue = fileReader.read()) != -1) {

            for (char later : englishLatter) {

                char selectedCharacter = (char) readingValue;
                if (later == selectedCharacter) {

                    int charArraySize = capitalLaterArray.length;
                    char[] temporaryCharArray = new char[charArraySize + 1];

                    if (charArraySize == 0) {
                        temporaryCharArray[0] = selectedCharacter;
                    } else {

                        for (int index = 0; index < charArraySize; index++) {

                            temporaryCharArray[index] = capitalLaterArray[index];
                        }
                        temporaryCharArray[charArraySize] = selectedCharacter;
                    }

                    capitalLaterArray = temporaryCharArray;

                    break;
                }
            }


        }

        fileReader.close();


        return capitalLaterArray;
    }


}
