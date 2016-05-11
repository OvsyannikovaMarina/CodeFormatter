package it.sevenbits.code_formatter.writer.implementation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test
 */
public class StringWriterTest {

    private StringWriter newStringWriter;

    @Before
    public void setUp() throws Exception {
        newStringWriter = new StringWriter();
    }

    @Test
    public void testWrite() throws Exception {
        int[] testChar = {'t', 'e', 's', 't'};
        for (int i = 0; i < testChar.length; i++) {
            newStringWriter.write(testChar[i]);
        }
        String actual = newStringWriter.toString();
        String expected = "test";
        assertEquals("wrong writing to String", expected, actual);
    }
}