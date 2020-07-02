package com.sergeev.day5.service.impl;

import com.sergeev.day5.exception.ProgramException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegexChangeServiceTextImplTest {

    private RegexChangeServiceTextImpl regexChangeServiceText;

    @BeforeMethod
    public void setUp() {
        regexChangeServiceText = new RegexChangeServiceTextImpl();
    }

    @Test
    public void testChangeSymbolInWordByIndex() throws ProgramException {
        String text = "Edit the Expression & Text 123 to see matches.";
        String actual = regexChangeServiceText.changeSymbolInWordByIndex(text, 1, 'O');
        String expected = "Odit Ohe Oxpression & Oext 123 Oo Oee Oatches.";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testChangeSymbolInWordByIndexInNullText() throws ProgramException {
        regexChangeServiceText.changeSymbolInWordByIndex(null, 1, ';');
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testChangeSymbolInWordByInvalidIndexInText() throws ProgramException {
        regexChangeServiceText.changeSymbolInWordByIndex("Hi, Dan", 0, ';');
    }

    @Test
    public void testChangeWordWithWrongLetterAAfterP() throws ProgramException {
        String text = "Papat the Exppassion & Text 123 to see matches.";
        String actual = regexChangeServiceText.changeWordWithWrongLetterAAfterP(text);
        String expected = "Popot the Exppossion & Text 123 to see matches.";
        assertEquals(actual, expected);
    }


    @Test(expectedExceptions = ProgramException.class)
    public void testChangeWordWithWrongLetterAAfterPInNullText() throws ProgramException {
        regexChangeServiceText.changeWordWithWrongLetterAAfterP(null);
    }

    @Test
    public void testChangeWordByQuantityWithNewLine() throws ProgramException {
        String text = "Edit the Expression & Text 123 to see matches.";
        String actual = regexChangeServiceText.changeWordByQuantityWithNewLine(text, 4, "helloo");
        String expected = "helloo the Expression & helloo 123 to see matches.";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testChangeWordByQuantityWithNewLineInEmptyText() throws ProgramException {
        regexChangeServiceText.changeWordByQuantityWithNewLine("", 4, "hello");
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testChangeWordByInvalidQuantityWithNewLineInText() throws ProgramException {
        regexChangeServiceText.changeWordByQuantityWithNewLine("London Paris Minsk", 0, "hello");
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testChangeWordByQuantityWithInvalidNewLineInText() throws ProgramException {
        regexChangeServiceText.changeWordByQuantityWithNewLine("London Paris Minsk", 2, null);
    }
}
