package it.sevenbits.code_formatter.writer.implementation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test
 */
public class FileWriterTest {

    private FileWriter newFileWriter;

    @Before
    public void setUp() throws Exception {
        newFileWriter = new FileWriter("testInput.txt");

    }

    @After
    public void tearDown() throws Exception {
        newFileWriter.close();
    }

    @Test
    public void testWriteToFile() throws Exception {

    }
}