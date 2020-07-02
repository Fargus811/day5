package com.sergeev.day5.service;

import com.sergeev.day5.exception.ProgramException;

public interface ChangeTextService {

    String changeSymbolInWordByIndex(String text, int index, char symbol) throws ProgramException;

    String changeWordWithWrongLetterAAfterP(String text) throws ProgramException;

    String changeWordByQuantityWithNewLine(String text, int quantity, String toReplace) throws ProgramException;


}
