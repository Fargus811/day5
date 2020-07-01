package com.sergeev.day5.service.impl;

import com.sergeev.day5.exception.ProgramException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringChangeTextImplTest {

    private StringChangeTextImpl stringChangeText;

    @BeforeMethod
    public void setUp() {
        stringChangeText = new StringChangeTextImpl();
    }

    @Test
    public void testChangeSymbolInWordByIndex() throws ProgramException {
        String text = "Edit the Expression & Text 123 to see matches.";
        String actual = stringChangeText.changeSymbolInWordByIndex(text,1,'O');
        String expected = "Odit Ohe Oxpression & Oext 123 Oo Oee Oatches.";
        assertEquals(actual,expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testChangeSymbolInWordByIndexInNullText() throws ProgramException {
        stringChangeText.changeSymbolInWordByIndex(null,1,';');
    }


    @Test
    public void testChangeWordWithWrongLetterAAfterP() throws ProgramException {
        String text = "Papa the Exppassion & Text 123 to see matches.";
        String actual = stringChangeText.changeWordWithWrongLetterAAfterP(text);
        String expected = "Popo the Exppossion & Text 123 to see matches.";
        assertEquals(actual,expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testChangeWordWithWrongLetterAAfterPInNullText() throws ProgramException {
        stringChangeText.changeWordWithWrongLetterAAfterP(null);
    }

    @Test
    public void testChangeWordByQuantityWithNewLine() throws ProgramException{
        String text = "Edit the Expression & Text 123 to see matches.";
        String actual = stringChangeText.changeWordByQuantityWithNewLine(text,4,"helloo");
        String expected ="helloo the Expression & helloo 123 to see matches.";
        assertEquals(actual,expected);
    }
    @Test(expectedExceptions = ProgramException.class)
    public void testChangeWordByQuantityWithNewLineInEmptyText() throws ProgramException {
        stringChangeText.changeWordByQuantityWithNewLine("",4,"hello");
    }

}

