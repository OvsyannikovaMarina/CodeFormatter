package it.sevenbits.code_formatter.writer.implementation;

import it.sevenbits.code_formatter.writer.IWriter;

import java.io.IOException;

/**
 * Created by marina on 21.04.16.
 */
public class StringWriter implements IWriter {

    private java.io.StringWriter output;

    public StringWriter() {
        output = new java.io.StringWriter();
    }

    public void write(int b) throws IOException {
        output.write(b);
    }

    public void print() {
        System.out.print(output.toString());
    }
}
