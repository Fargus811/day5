package com.sergeev.day5.service.impl;

import com.sergeev.day5.exception.ProgramException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegexDeleteTextServiceImplTest {

    private RegexDeleteTextServiceImpl regexDeleteTextService;

    @BeforeMethod
    public void setUp() {
        regexDeleteTextService = new RegexDeleteTextServiceImpl();
    }


    @Test
    public void testDeletePunctuationInText() throws ProgramException {
        String text = "RegExr was created by gskinner, and is proudly hosted by Media Temple!!";
        String actual = regexDeleteTextService.deletePunctuationInText(text);
        String expected = "RegExr was created by gskinner  and is proudly hosted by Media Temple";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testDeletePunctuationInEmptyText() throws ProgramException {
        regexDeleteTextService.deletePunctuationInText("");
    }

    @Test
    public void testDeleteTextWithConsonantOfGivenLength() throws ProgramException {
        String text = "RegExr was created by gskinner, and is proudly hosted by Media Temple!";
        String actual = regexDeleteTextService.deleteTextWithConsonantOfGivenLength(text, 6);
        String expected = "was created by gskinner, and is proudly  by Media !";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testDeleteWordsInNullTextWithConsonantOfGivenLength() throws ProgramException {
        regexDeleteTextService.deleteTextWithConsonantOfGivenLength(null, 2);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testDeleteWordsInTextWithConsonantOfGivenInvalidLength() throws ProgramException {
        regexDeleteTextService.deleteTextWithConsonantOfGivenLength("HI, Omigo!", -1);
    }
}
