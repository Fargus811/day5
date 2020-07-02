package com.sergeev.day5.service.impl;

import com.sergeev.day5.exception.ProgramException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayDeleteTextServiceImplTest {

    private ArrayDeleteTextServiceImpl arrayDeleteTextService;

    @BeforeMethod
    public void setUp() {
        arrayDeleteTextService = new ArrayDeleteTextServiceImpl();
    }

    @Test
    public void testDeletePunctuationInText() throws ProgramException {
        String text = "RegExr was created by gskinner, and is proudly hosted by Media Temple!!";
        String actual = arrayDeleteTextService.deletePunctuationInText(text);
        String expected = "RegExr was created by gskinner  and is proudly hosted by Media Temple";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testDeletePunctuationInEmptyText() throws ProgramException {
        arrayDeleteTextService.deletePunctuationInText("");
    }

    @Test
    public void testDeleteTextWithConsonantOfGivenLength() throws ProgramException {
        String text = "RegExr was created by gskinner, and is proudly hosted by Media Temple!";
        String actual = arrayDeleteTextService.deleteTextWithConsonantOfGivenLength(text, 6);
        String expected = "was created by gskinner, and is proudly  by Media !";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testDeleteWordsInNullTextWithConsonantOfGivenLength() throws ProgramException {
        arrayDeleteTextService.deleteTextWithConsonantOfGivenLength(null, 2);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testDeleteWordsInTextWithConsonantOfGivenInvalidLength() throws ProgramException {
        arrayDeleteTextService.deleteTextWithConsonantOfGivenLength("HI, Omigo!", -1);
    }
}
