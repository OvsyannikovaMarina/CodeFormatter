package it.sevenbits.code_formatter.writer.implementation;

import it.sevenbits.code_formatter.writer.IWriter;

import java.io.*;

/**
 * Class provides
 */
public class FileWriter implements IWriter, Closeable {

    private Writer output;

    public FileWriter(String filename) throws IOException {
        output = new java.io.FileWriter(new File(filename));
    }

    public void write(int b) throws IOException {
        output.write(b);
        output.flush();
    }

    public void print() {

    }

    public void close() throws IOException {
        output.close();
    }
}
