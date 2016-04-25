package it.sevenbits.code_formatter.formatter;

import it.sevenbits.code_formatter.reader.implementation.FileReader;
import it.sevenbits.code_formatter.reader.implementation.StringReader;
import it.sevenbits.code_formatter.writer.implementation.FileWriter;
import it.sevenbits.code_formatter.writer.implementation.StringWriter;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class
 */
public class FormatterTest {

    @Before
    public void setUp() throws Exception {
        String str = "while (x==0){print(x);}";
        Formatter testFormatter = new Formatter();
        FileWriter testInputFile = new FileWriter("input.txt");
        StringWriter testInputString = new StringWriter();
        FileReader testOutputFile = new FileReader("output.txt");
        StringReader testOutputString = new StringReader(str);
    }

    @Test
    public void testSpaces() throws Exception {

    }

    @Test
    public void test() throws Exception {

    }
}