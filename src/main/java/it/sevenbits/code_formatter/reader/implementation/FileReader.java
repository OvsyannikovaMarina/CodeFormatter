package it.sevenbits.code_formatter.reader.implementation;

import it.sevenbits.code_formatter.reader.IReader;

import java.io.*;

/**
 * Created by marina on 21.04.16.
 */
public class FileReader implements IReader{

    private Reader file_reader;

    public FileReader(String filename) throws FileNotFoundException {
        file_reader = new java.io.FileReader(new File(filename));
    }

    public int read() throws IOException {
        return file_reader.read();
    }
}
