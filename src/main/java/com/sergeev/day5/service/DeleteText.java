package com.sergeev.day5.service;

public interface DeleteText {

    String deletePunctuationInText(String text);

    String deleteTextWithConsonantOfGivenLength(String text, int length);
}
