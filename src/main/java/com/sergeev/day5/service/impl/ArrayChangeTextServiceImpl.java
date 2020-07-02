package com.sergeev.day5.service.impl;

import com.sergeev.day5.exception.ProgramException;
import com.sergeev.day5.service.ChangeTextService;
import com.sergeev.day5.validator.TextValidator;

import java.util.Arrays;

public class ArrayChangeTextServiceImpl implements ChangeTextService {

    private static final String DELIMITER = " ";
    private static final char LETTER_P = 'P';
    private static final char LETTER_A = 'A';
    private static final char LETTER_P_LOWER_CASE = 'p';
    private static final char LETTER_A_LOWER_CASE = 'a';

    private TextValidator textValidator = new TextValidator();

    @Override
    public String changeSymbolInWordByIndex(String text, int index, char symbol) throws ProgramException {
        textValidator.validateTextNotNullOrEmpty(text);
        textValidator.validateDigitParameter(index);
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
        textValidator.validateTextNotNullOrEmpty(text);
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
        textValidator.validateTextNotNullOrEmpty(text);
        textValidator.validateTextNotNullOrEmpty(toReplace);
        textValidator.validateDigitParameter(quantity);
        String[] strings = Arrays.stream(text.split(DELIMITER)).map(String::trim).toArray(String[]::new);
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : strings) {
            if (word.length() == quantity) {
                stringBuilder.append(toReplace).append(DELIMITER);
            } else {
                stringBuilder.append(word).append(DELIMITER);
            }
        }
        return stringBuilder.toString().trim();
    }
}
