package com.sergeev.day5.service;

public interface ChangeText {

    String changeSymbolInWordByIndex(String text, int index, char symbol);

    String changeWordWithWrongLetterA(String text);

    String changeWordByQuantityWithNewLine(String text, int quantity, String toReplace);


}
