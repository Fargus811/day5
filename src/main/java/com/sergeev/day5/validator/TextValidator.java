package com.sergeev.day5.validator;

import com.sergeev.day5.exception.ProgramException;

public class TextValidator {

    private static final String EMPTY_LINE = "";

    public void isTextNotNullOrEmpty(String text) throws ProgramException{
        if (text == null || text.equals(EMPTY_LINE)){
            throw new ProgramException("Text is invalid");
        }
    }
}
