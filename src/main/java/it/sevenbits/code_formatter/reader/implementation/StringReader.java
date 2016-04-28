package it.sevenbits.code_formatter.reader.implementation;

import it.sevenbits.code_formatter.reader.IReader;
import it.sevenbits.code_formatter.reader.ReaderException;

import java.io.IOException;
import java.io.Reader;

/**
 * Class provides reading from String
 */
public class StringReader implements IReader {

    private Reader string_reader;

    public StringReader(String s) {
        string_reader = new java.io.StringReader(s);
    }

    public int read() throws ReaderException {
        try {
            return string_reader.read();
        } catch (IOException e) {
            throw new ReaderException(e);
        }

    }
}
