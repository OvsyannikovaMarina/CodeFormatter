package it.sevenbits.code_formatter.writer.implementation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;

import static org.junit.Assert.*;

/**
 * Test
 */
public class FileWriterTest {

    private FileWriter newFileWriter;
    private java.io.FileReader newFileReader;

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