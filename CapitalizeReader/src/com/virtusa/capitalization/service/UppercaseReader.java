package com.chazool.capitalization.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class UppercaseReader extends BufferedReader {

    public UppercaseReader(Reader reader) {
        super(reader);
    }

    @Override
    public String readLine() throws IOException {

        String textLine = super.readLine();

        if (textLine == null) {
            textLine = null;
        } else {
            textLine = textLine.toUpperCase();
        }
        return textLine;
    }

}
