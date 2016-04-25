package it.sevenbits.code_formatter.writer.implementation;

import it.sevenbits.code_formatter.writer.IWriter;

import java.io.IOException;

/**
 * Class provides writing to String
 */
public class StringWriter implements IWriter {

    private java.io.StringWriter output;

    public StringWriter() {
        output = new java.io.StringWriter();
    }

    public void write(int b) throws IOException {
        output.write(b);
    }

    @Override
    public String toString() {
        return output.toString();
    }
}
