package com.sergeev.day5.service.impl;

import com.sergeev.day5.exception.ProgramException;
import com.sergeev.day5.service.DeleteText;
import com.sergeev.day5.validator.TextValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDeleteTextServiceImpl implements DeleteText {

    private static final String REGEX_TO_DELETE_PUNCTUATION = "[^a-zA-Z-А-Яа-я-\\s]";
    private static final String REGEX_TO_DELETE_CONSONANT = "\\b([^aeiouyAEIOUY\\s.][\\w]{%s})\\b";
    private static final String EMPTY_LINE = "";
    private static final String DELIMITER = " ";

    private TextValidator textValidator = new TextValidator();

    @Override
    public String deletePunctuationInText(String text) throws ProgramException {
        textValidator.isTextNotNullOrEmpty(text);
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile(REGEX_TO_DELETE_PUNCTUATION);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            matcher.appendReplacement(sb, DELIMITER);
        }
        matcher.appendTail(sb);
        return sb.toString().trim();
    }

    @Override
    public String deleteTextWithConsonantOfGivenLength(String text, int length) throws ProgramException {
        textValidator.isTextNotNullOrEmpty(text);
        int sizeOfWord = length - 1;
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile(String.format(REGEX_TO_DELETE_CONSONANT, sizeOfWord));
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            matcher.appendReplacement(sb, EMPTY_LINE);
        }
        matcher.appendTail(sb);
        return sb.toString().trim();
    }
}
