package com.sergeev.reader;

import com.sergeev.exception.ProgramException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TextConsoleReader {

    private static final String SEPARATOR = " ";

    public String createTextFromFile(String pathToFile) throws ProgramException {
        String  result;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
            result = bufferedReader.readLine();
        } catch (IOException e) {
            throw new ProgramException("File not found");
        }
        return result;
    }

}
