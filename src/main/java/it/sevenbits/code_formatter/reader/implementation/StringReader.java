package it.sevenbits.code_formatter.reader.implementation;

import it.sevenbits.code_formatter.reader.IReader;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by marina on 20.04.16.
 */
public class StringReader implements IReader {

    private Reader string_reader;

    public StringReader(String s) {
        string_reader = new java.io.StringReader(s);
    }

    public int read() throws IOException {
        return string_reader.read();
    }
}
