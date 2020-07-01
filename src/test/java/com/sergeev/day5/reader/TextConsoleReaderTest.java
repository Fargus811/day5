package com.sergeev.day5.reader;

import com.sergeev.day5.exception.ProgramException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.testng.Assert.assertEquals;

public class TextConsoleReaderTest {

    private TextConsoleReader textConsoleReader;
    private final static String PATH_TO_TEST_FILE = "src/main/resources/dataTextToTestConsole.txt";

    @BeforeMethod
    public void setUp() {
        textConsoleReader = new TextConsoleReader();
    }

    @Test
    public void testReadFromConsole() throws ProgramException, FileNotFoundException {
        System.setIn(new BufferedInputStream(new FileInputStream(PATH_TO_TEST_FILE)));
        String actual = textConsoleReader.readFromConsole();
        String expected = "Hello World ";
        assertEquals(actual,expected);
    }
}
