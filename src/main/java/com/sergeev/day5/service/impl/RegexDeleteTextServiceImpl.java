package com.sergeev.day5.service.impl;

import com.sergeev.day5.service.DeleteText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDeleteTextServiceImpl implements DeleteText {

    private static final String REGEX_TO_DELETE_PUNCTUATION = "[^a-zA-Z-А-Яа-я-\\s]";
    private static final String REGEX_TO_DELETE_CONSONANT = "\\b([^aeiouyAEIOUY\\s\\.][\\w]{";
    private static final String REGEX_TO_DELETE_ENDING = "})\\b";
    private static final String EMPTY_LINE = "";

    @Override
    public String deletePunctuationInText(String text) {
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile(REGEX_TO_DELETE_PUNCTUATION);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            matcher.appendReplacement(sb, " ");
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    @Override
    public String deleteTextWithConsonantOfGivenLength(String text, int length) {
        int sizeOfWord = length + 1;
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile(REGEX_TO_DELETE_CONSONANT + sizeOfWord + REGEX_TO_DELETE_ENDING);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            matcher.appendReplacement(sb, EMPTY_LINE);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
