package com.sergeev.day5.reader;

import com.sergeev.day5.exception.ProgramException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

    private static final String DELIMITER = "\n";
    private static final String EMPTY_LINE = "";

    public String createTextFromFile(String pathToFile) throws ProgramException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(pathToFile));
            readFile(stringBuilder, bufferedReader);
        } catch (IOException e) {
            throw new ProgramException("File not found", e);
        } finally {
            closeReader(bufferedReader);
        }
        validateNotEmpty(stringBuilder);
        return stringBuilder.toString();
    }

    private void readFile(StringBuilder stringBuilder, BufferedReader bufferedReader) throws IOException {
        String nextLine;
        while ((nextLine = bufferedReader.readLine()) != null) {
            addLineToResultText(stringBuilder, nextLine);
        }
    }

    private void closeReader(BufferedReader bufferedReader) throws ProgramException {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new ProgramException("Error in buffered reader", e);
            }
        }
    }

    private void addLineToResultText(StringBuilder stringBuilder, String nextLine) {
        if (stringBuilder.toString().equals(EMPTY_LINE)) {
            stringBuilder.append(nextLine);
        } else {
            stringBuilder.append(DELIMITER).append(nextLine);
        }
    }

    private void validateNotEmpty(StringBuilder stringBuilder) throws ProgramException {
        if (stringBuilder.toString().isEmpty()) {
            throw new ProgramException("StringBuilder is empty");
        }
    }
}
