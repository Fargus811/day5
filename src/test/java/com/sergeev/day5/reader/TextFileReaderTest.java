package com.sergeev.day5.reader;

import com.sergeev.day5.exception.ProgramException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextFileReaderTest {

    private TextFileReader textFileReader;
    private final static String PATH_TO_FILE = "src/main/resources/dataTextTestReader.txt";
    private final static String PATH_TO_EMPTY_FILE = "src/main/resources/emptyFileTest.txt";
    private final static String WRONG_PATH_TO_FILE = "src/main/resources/data.txt";

    @BeforeMethod
    public void setUp() {
        textFileReader = new TextFileReader();
    }

    @Test
    public void testCreateTextFromFile() throws ProgramException {
        String actual = textFileReader.createTextFromFile(PATH_TO_FILE);
        String expected = "RegExr was created by gskinner.com, and is proudly hosted by Media Temple.\n" +
                "Edit the Expression & Text to see matches. Roll over matches or the expression for details.";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testCreateTextFromFileWrongPathProgramException() throws ProgramException {
        textFileReader.createTextFromFile(WRONG_PATH_TO_FILE);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testCreateTextFromEmptyFileProgramException() throws ProgramException {
        textFileReader.createTextFromFile(PATH_TO_EMPTY_FILE);
    }
}
