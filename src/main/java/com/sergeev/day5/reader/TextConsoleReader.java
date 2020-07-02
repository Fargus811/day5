package com.sergeev.day5.reader;

import com.sergeev.day5.exception.ProgramException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextConsoleReader {

    private static final String LINE_TO_EXIT = "exit";
    private static final String DELIMITER = " ";

    public String readFromConsole() throws ProgramException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String lineFromConsole;
            while (true) {
                lineFromConsole = reader.readLine();
                if (lineFromConsole.equals(LINE_TO_EXIT)) {  //The end of input is: "exit"
                    break;
                }
                stringBuilder.append(lineFromConsole).append(DELIMITER);
            }
            reader.close();
        } catch (IOException e) {
            throw new ProgramException("Console error", e);
        }
        return stringBuilder.toString();
    }
}

