package com.sergeev.day5.service.impl;

import com.sergeev.day5.exception.ProgramException;
import com.sergeev.day5.service.DeleteText;
import com.sergeev.day5.validator.TextValidator;

import java.util.Arrays;

public class ArrayDeleteTextServiceImpl implements DeleteText {

    private static final char INSTEAD_OF_PUNCTUATION = ' ';
    private static final String DELIMITER = " ";
    private static final String EMPTY_LINE = "";
    private static final String VOWELS = "aeiouAEIOU";
    private static int PUNCTUATION_MARK_END = 2;

    private TextValidator textValidator = new TextValidator();

    @Override
    public String deletePunctuationInText(String text) throws ProgramException {
        textValidator.isTextNotNullAndEmpty(text);
        char[] textArray = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char symbol : textArray) {
            if (!Character.isLetterOrDigit(symbol)) {
                symbol = INSTEAD_OF_PUNCTUATION;
            }
            stringBuilder.append(symbol);
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public String deleteTextWithConsonantOfGivenLength(String text, int lengthOfWordToDelete) throws ProgramException {
        textValidator.isTextNotNullAndEmpty(text);
        String[] stringArray = Arrays.stream(text.split(DELIMITER)).map(String::trim).toArray(String[]::new);
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : stringArray) {
            stringBuilder.append(removeWordBeginningWithConsonant(lengthOfWordToDelete - 1, line)).append(DELIMITER);
        }
        return stringBuilder.toString().trim();
    }

    private String removeWordBeginningWithConsonant(int length, String line) {
        char[] word = line.toCharArray();
        if (isEndsWithPunctuationMark(length, line, word)) {
            return EMPTY_LINE + word[line.length() - 1];
        }
        if (line.length() == length + 1) {
            if (VOWELS.indexOf(word[0]) != 0) {
                return EMPTY_LINE;
            }
        }
        return line;
    }

    private boolean isEndsWithPunctuationMark(int length, String line, char[] word) {
        if (line.length() <= length) {
            return false;
        }
        if (word.length == length + PUNCTUATION_MARK_END && !Character.isLetter(word[word.length - 1])) {
            if (line.length() == length + PUNCTUATION_MARK_END) {
                if (VOWELS.indexOf(word[0]) != 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
