package com.sergeev.day5.service.impl;

import com.sergeev.day5.exception.ProgramException;
import com.sergeev.day5.service.DeleteTextService;
import com.sergeev.day5.validator.TextValidator;

public class StringDeleteTextImpl implements DeleteTextService {

    private static final String DELIMITER = " ";
    private static final char INSTEAD_OF_PUNCTUATION = ' ';
    private static final String VOWELS = "aeiouAEIOU";

    private TextValidator textValidator = new TextValidator();

    @Override
    public String deletePunctuationInText(String text) throws ProgramException {
        textValidator.validateTextNotNullOrEmpty(text);
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

    private String getWordWithoutPunctuationMark(String newLine, String word, int indexOfChar) {
        char comparing = word.charAt(indexOfChar);
        if (!Character.isLetterOrDigit(comparing)) {
            newLine = word.replaceAll(String.valueOf(comparing), String.valueOf(INSTEAD_OF_PUNCTUATION));
        }
        return newLine;
    }

    @Override
    public String deleteTextWithConsonantOfGivenLength(String text, int lengthOfWordToDelete) throws ProgramException {
        textValidator.validateTextNotNullOrEmpty(text);
        textValidator.validateDigitParameter(lengthOfWordToDelete);
        String[] strings = text.split(DELIMITER);
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : strings) {
            if (!word.startsWith(VOWELS)) {
                if (isLastSymbolNotLetterOrDigit(word, lengthOfWordToDelete)) {
                    leaveOnlyPunctuationMark(lengthOfWordToDelete, word, stringBuilder);
                } else if (word.length() == lengthOfWordToDelete) {
                    stringBuilder.append(DELIMITER);
                } else {
                    stringBuilder.append(word).append(DELIMITER);
                }
            } else {
                stringBuilder.append(word).append(DELIMITER);
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
        return !Character.isLetterOrDigit(wordSymbols[wordSymbols.length - 1]) && word.length() == length + 1;
    }
}
