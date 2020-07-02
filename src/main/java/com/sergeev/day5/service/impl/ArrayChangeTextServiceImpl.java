package com.sergeev.day5.service.impl;

import com.sergeev.day5.exception.ProgramException;
import com.sergeev.day5.service.ChangeText;
import com.sergeev.day5.validator.TextValidator;

import java.util.Arrays;

public class ArrayChangeTextServiceImpl implements ChangeText {

    private static final String DELIMITER = " ";
    private static final char LETTER_P = 'P';
    private static final char LETTER_A = 'A';
    private static final char LETTER_P_LOWER_CASE = 'p';
    private static final char LETTER_A_LOWER_CASE = 'a';

    private TextValidator textValidator = new TextValidator();

    @Override
    public String changeSymbolInWordByIndex(String text, int index, char symbol) throws ProgramException {
        textValidator.isTextNotNullOrEmpty(text);
        String[] strings = Arrays.stream(text.split(DELIMITER)).map(String::trim).toArray(String[]::new);
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : strings) {
            if (word.length() >= index) {
                char[] charsOfWord = word.toCharArray();
                if (Character.isLetter(charsOfWord[index - 1])) {
                    charsOfWord[index - 1] = symbol;
                }
                stringBuilder.append(String.valueOf(charsOfWord)).append(DELIMITER);
            } else {
                stringBuilder.append(word).append(DELIMITER);
            }
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public String changeWordWithWrongLetterAAfterP(String text) throws ProgramException {
        textValidator.isTextNotNullOrEmpty(text);
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length - 1; i++) {
            if (isSuitableWithLettersPAndA(textArray, i)) {
                textArray[i + 1] = 'o';
            }
        }
        return new String(textArray);
    }

    private boolean isSuitableWithLettersPAndA(char[] textArray, int i) {
        return textArray[i] == LETTER_P || textArray[i] == LETTER_P_LOWER_CASE
                && textArray[i + 1] == LETTER_A_LOWER_CASE || textArray[i + 1] == LETTER_A;
    }

    @Override
    public String changeWordByQuantityWithNewLine(String text, int quantity, String toReplace) throws ProgramException {
        textValidator.isTextNotNullOrEmpty(text);
        String[] strings = Arrays.stream(text.split(DELIMITER)).map(String::trim).toArray(String[]::new);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == quantity) {
                stringBuilder.append(toReplace).append(DELIMITER);
            } else {
                stringBuilder.append(strings[i]).append(DELIMITER);
            }
        }
        return stringBuilder.toString().trim();
    }
}
