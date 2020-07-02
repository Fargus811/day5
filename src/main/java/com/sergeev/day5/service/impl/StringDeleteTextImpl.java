package com.sergeev.day5.service.impl;

import com.sergeev.day5.exception.ProgramException;
import com.sergeev.day5.service.DeleteText;
import com.sergeev.day5.validator.TextValidator;

public class StringDeleteTextImpl implements DeleteText {

    private static final String DELIMITER = " ";
    private static final char INSTEAD_OF_PUNCTUATION = ' ';
    private static final String VOWELS = "aeiouAEIOU";

    private TextValidator textValidator = new TextValidator();

    @Override
    public String deletePunctuationInText(String text) throws ProgramException {
        textValidator.isTextNotNullOrEmpty(text);
        String[] strings = text.split(DELIMITER);
        StringBuilder stringBuilder = new StringBuilder();
        String newLine;
        for (String word : strings) {
            newLine = word;
            for (int i = 0; i < word.length(); i++) {
                newLine = getWordWithoutPunctuationMark(newLine, word, i);
            }
            stringBuilder.append(newLine).append(DELIMITER);
        }
        return stringBuilder.toString().trim();
    }

    private String getWordWithoutPunctuationMark(String newLine, String word, int i) {
        char comparing = word.charAt(i);
        if (!Character.isLetterOrDigit(comparing)) {
            newLine = word.replaceAll(String.valueOf(comparing), String.valueOf(INSTEAD_OF_PUNCTUATION));
        }
        return newLine;
    }

    @Override
    public String deleteTextWithConsonantOfGivenLength(String text, int length) throws ProgramException {
        textValidator.isTextNotNullOrEmpty(text);
        String[] strings = text.split(DELIMITER);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].startsWith(VOWELS)) {
                if (isLastSymbolNotLetterOrDigit(strings[i],length)) {
                    leaveOnlyPunctuationMark(length, strings[i], stringBuilder);
                } else if (strings[i].length() == length) {
                    stringBuilder.append(DELIMITER);
                } else {
                    stringBuilder.append(strings[i]).append(DELIMITER);
                }
            } else {
                stringBuilder.append(strings[i]).append(DELIMITER);
            }
        }
        return stringBuilder.toString().trim();
    }

    private void leaveOnlyPunctuationMark(int length, String word, StringBuilder stringBuilder) {
        String ending = word.substring(length);
        stringBuilder.append(ending).append(DELIMITER);
    }

    private boolean isLastSymbolNotLetterOrDigit(String word, int length) {
        char[] wordSymbols = word.toCharArray();
        return !Character.isLetterOrDigit(wordSymbols[wordSymbols.length - 1]) && word.length() == length + 1 ;
    }
}
