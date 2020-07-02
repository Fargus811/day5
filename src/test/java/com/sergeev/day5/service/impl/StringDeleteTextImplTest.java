package com.sergeev.day5.service.impl;

import com.sergeev.day5.exception.ProgramException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StringDeleteTextImplTest {

    private StringDeleteTextImpl stringDeleteTextService;

    @BeforeMethod
    public void setUp() {
        stringDeleteTextService = new StringDeleteTextImpl();
    }

    @Test
    public void testDeletePunctuationInText() throws ProgramException {
        String text = "RegExr was created by gskinner, and is proudly hosted by Media Temple!!";
        String actual = stringDeleteTextService.deletePunctuationInText(text);
        String expected = "RegExr was created by gskinner  and is proudly hosted by Media Temple";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testDeletePunctuationInEmptyText() throws ProgramException {
        stringDeleteTextService.deletePunctuationInText("");
    }

    @Test
    public void testDeleteTextWithConsonantOfGivenLength() throws ProgramException {
        String text = "RegExr was created by gskinner, and is proudly hosted by Media Temple!";
        String actual = stringDeleteTextService.deleteTextWithConsonantOfGivenLength(text, 6);
        String expected = "was created by gskinner, and is proudly  by Media !";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testDeleteWordsInNullTextWithConsonantOfGivenLength() throws ProgramException {
        stringDeleteTextService.deleteTextWithConsonantOfGivenLength(null, 2);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testDeleteWordsInTextWithConsonantOfGivenInvalidLength() throws ProgramException {
        stringDeleteTextService.deleteTextWithConsonantOfGivenLength("HI, Omigo!", -1);
    }
}
