package it.sevenbits.code_formatter.writer.implementation;

import it.sevenbits.code_formatter.writer.IWriter;
import it.sevenbits.code_formatter.writer.WriterException;

import java.io.IOException;

/**
 * Class provides writing to String
 */
public class StringWriter implements IWriter {

    private java.io.StringWriter output;

    public StringWriter() {
        output = new java.io.StringWriter();
    }

    public void write(int b) throws WriterException {
        output.write(b);
    }

    @Override
    public String toString() {
        return output.toString();
    }
}
