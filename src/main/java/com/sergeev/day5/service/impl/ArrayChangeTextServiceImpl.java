package com.sergeev.day5.service.impl;

import com.sergeev.day5.service.ChangeText;

import java.util.Arrays;

public class ArrayChangeTextServiceImpl implements ChangeText {

    private static final String DELIMETR = " ";

    @Override
    public String changeSymbolInWordByIndex(String text, int index, char symbol) {
        String[] stringArray = Arrays.stream(text.split(DELIMETR)).map(String::trim).toArray(String[]::new);
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : stringArray) {
            if (word.length() >= index) {
                char[] charsOfWord = word.toCharArray();
                if (Character.isLetter(charsOfWord[index - 1])) {
                    charsOfWord[index - 1] = symbol;
                }
                stringBuilder.append(String.valueOf(charsOfWord)).append(DELIMETR);
            } else {
                stringBuilder.append(word).append(DELIMETR);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String changeWordWithWrongLetterA(String text) {
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length - 1; i++) {
            if (isSuitableWithLettersPAndA(textArray, i)) {
                textArray[i + 1] = 'o';
            }
        }
        return new String(textArray);
    }

    private boolean isSuitableWithLettersPAndA(char[] textArray, int i) {
        return textArray[i] == 'P' || textArray[i] == 'p' && textArray[i + 1] == 'a' || textArray[i + 1] == 'A';
    }

    @Override
    public String changeWordByQuantityWithNewLine(String text, int quantity, String toReplace) {
        String[] stringArray = Arrays.stream(text.split(DELIMETR)).map(String::trim).toArray(String[]::new);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].length() == quantity) {
                stringBuilder.append(toReplace).append(DELIMETR);
            }
            stringBuilder.append(stringArray[i]).append(DELIMETR);
        }
        return stringBuilder.toString();
    }
}
