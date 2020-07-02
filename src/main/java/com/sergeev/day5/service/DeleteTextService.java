package com.sergeev.day5.service;

import com.sergeev.day5.exception.ProgramException;

public interface DeleteTextService {

    String deletePunctuationInText(String text) throws ProgramException;

    String deleteTextWithConsonantOfGivenLength(String text, int length) throws ProgramException;
}
