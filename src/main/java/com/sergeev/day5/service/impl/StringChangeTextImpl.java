package com.sergeev.day5.service.impl;

import com.sergeev.day5.exception.ProgramException;
import com.sergeev.day5.service.ChangeText;
import com.sergeev.day5.validator.TextValidator;

public class StringChangeTextImpl implements ChangeText {

    private static final String DELIMITER = " ";
    private static final String WRONG_LETTERS_LOWER_CASE = "pa";
    private static final String WRONG_LETTERS_UPPER_CASE = "Pa";
    private static final String RIGHT_LETTERS_LOWER_CASE = "po";
    private static final String RIGHT_LETTERS_UPPER_CASE = "Po";

    private TextValidator textValidator = new TextValidator();

    @Override
    public String changeSymbolInWordByIndex(String text, int index, char symbol) throws ProgramException {
        textValidator.isTextNotNullAndEmpty(text);
        String[] stringArray = text.split(DELIMITER);
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : stringArray) {
            char[] word = line.toCharArray();
            if (Character.isLetter(word[index - 1])) {
                String newLine = insertCharInWord(index, symbol, line);
                stringBuilder.append(newLine).append(DELIMITER);
            } else {
                stringBuilder.append(line).append(DELIMITER);
            }
        }
        return stringBuilder.toString().trim();
    }

    private String insertCharInWord(int index, char symbol, String line) {
        if (line.length() == index) {
            return line.substring(0, index - 1) + symbol;
        } else if (line.length() > index) {
            return line.substring(0, index - 1) + symbol + line.substring(index);
        } else {
            return line;
        }
    }

    @Override
    public String changeWordWithWrongLetterAAfterP(String text) throws ProgramException {
        textValidator.isTextNotNullAndEmpty(text);
        String[] stringArray = text.split(DELIMITER);
        StringBuilder builder = new StringBuilder();
        for (String string : stringArray) {
            if (isContainsLetterPAndA(string)) {
                changeWrongLetterA(builder, string);
            } else {
                builder.append(string).append(DELIMITER);
            }
        }
        return builder.toString().trim();
    }

    private void changeWrongLetterA(StringBuilder builder, String string) {
        String newString;
        newString = string.replaceAll(WRONG_LETTERS_LOWER_CASE, RIGHT_LETTERS_LOWER_CASE);
        if (newString.contains(WRONG_LETTERS_UPPER_CASE)) {
            newString = newString.replaceAll(WRONG_LETTERS_UPPER_CASE, RIGHT_LETTERS_UPPER_CASE);
            builder.append(newString).append(DELIMITER);
        } else {
            builder.append(newString).append(DELIMITER);
        }
    }

    private boolean isContainsLetterPAndA(String string) {
        return string.contains(WRONG_LETTERS_LOWER_CASE) || string.contains(WRONG_LETTERS_UPPER_CASE);
    }


    @Override
    public String changeWordByQuantityWithNewLine(String text, int quantity, String toReplace) throws ProgramException {
        textValidator.isTextNotNullAndEmpty(text);
        String[] words = text.split(DELIMITER);
        for (String word : words) {
            if (word.length() == quantity) {
                text = text.replaceAll(word, toReplace);
            }
        }
        return text;
    }
}
