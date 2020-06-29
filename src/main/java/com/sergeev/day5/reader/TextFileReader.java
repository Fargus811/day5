package com.sergeev.day5.reader;

import com.sergeev.day5.exception.ProgramException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

    private static final String SEPARATOR = " ";

    public String createTextFromFile(String pathToFile) throws ProgramException {
        String  result;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
            result = bufferedReader.readLine();
        } catch (IOException e) {
            throw new ProgramException("File not found", e);
        }
        return result;
    }
}
