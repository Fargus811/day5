package com.sergeev.day5.service.impl;

import com.sergeev.day5.exception.ProgramException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayChangeTextServiceImplTest {

    private ArrayChangeTextServiceImpl arrayChangeTextService;

    @BeforeMethod
    public void setUp() {
        arrayChangeTextService = new ArrayChangeTextServiceImpl();
    }

    @Test
    public void testChangeSymbolInWordByIndex() throws ProgramException {
        String text = "Edit the Expression & Text 123 to see matches.";
        String actual = arrayChangeTextService.changeSymbolInWordByIndex(text,1,'O');
        String expected = "Odit Ohe Oxpression & Oext 123 Oo Oee Oatches.";
        assertEquals(actual,expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testChangeSymbolInWordByIndexInNullText() throws ProgramException {
        arrayChangeTextService.changeSymbolInWordByIndex(null,1,';');
    }


    @Test
    public void testChangeWordWithWrongLetterAAfterP() throws ProgramException {
        String text = "Papat the Exppassion & Text 123 to see matches.";
        String actual = arrayChangeTextService.changeWordWithWrongLetterAAfterP(text);
        String expected = "Popot the Exppossion & Text 123 to see matches.";
        assertEquals(actual,expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testChangeWordWithWrongLetterAAfterPInNullText() throws ProgramException {
        arrayChangeTextService.changeWordWithWrongLetterAAfterP(null);
    }

    @Test
    public void testChangeWordByQuantityWithNewLine() throws ProgramException{
        String text = "Edit the Expression & Text 123 to see matches.";
        String actual = arrayChangeTextService.changeWordByQuantityWithNewLine(text,4,"helloo");
        String expected ="helloo the Expression & helloo 123 to see matches.";
        assertEquals(actual,expected);
    }
    @Test(expectedExceptions = ProgramException.class)
    public void testChangeWordByQuantityWithNewLineInEmptyText() throws ProgramException {
        arrayChangeTextService.changeWordByQuantityWithNewLine("",4,"hello");
    }

}
