package com.sergeev.day5.service.impl;

import com.sergeev.day5.exception.ProgramException;
import com.sergeev.day5.service.ChangeText;
import com.sergeev.day5.validator.TextValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChangeServiceTextImpl implements ChangeText {

    private static final String REGEX_TO_CHANGE_LETTER = "[a-zA-Z]{";
    private static final String REGEX_END = ",}";
    private static final String REGEX_FOR_WRONG_LETTER_A = "pa|Pa";
    private static final String REGEX_FOR_WORD_WITH_QUANTITY = "\\b[a-zA-Z0-9]{";
    private static final String REGEX_END_FOR_WORD_WITH_QUANTITY = "}\\b";
    private static final char RIGHT_SYMBOL = 'o';

    private TextValidator textValidator = new TextValidator();

    @Override
    public String changeSymbolInWordByIndex(String text, int index, char symbol) throws ProgramException {
        textValidator.isTextNotNullOrEmpty(text);
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile(REGEX_TO_CHANGE_LETTER + index + REGEX_END);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find() && matcher.group().length() >= index) {
            StringBuffer stringBuffer = new StringBuffer(matcher.group());
            stringBuffer.setCharAt(index - 1, symbol);
            matcher.appendReplacement(sb, stringBuffer.toString());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    @Override
    public String changeWordWithWrongLetterAAfterP(String text) throws ProgramException {
        textValidator.isTextNotNullOrEmpty(text);
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile(REGEX_FOR_WRONG_LETTER_A);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            StringBuffer stringBuffer = new StringBuffer(matcher.group());
            stringBuffer.setCharAt(matcher.group().length() - 1, RIGHT_SYMBOL);
            matcher.appendReplacement(sb, stringBuffer.toString());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    @Override
    public String changeWordByQuantityWithNewLine(String text, int quantity, String toReplace) throws ProgramException {
        textValidator.isTextNotNullOrEmpty(text);
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile(REGEX_FOR_WORD_WITH_QUANTITY+ quantity + REGEX_END_FOR_WORD_WITH_QUANTITY);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            matcher.appendReplacement(sb, toReplace);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
