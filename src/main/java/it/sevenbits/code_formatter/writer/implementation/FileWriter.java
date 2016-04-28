package it.sevenbits.code_formatter.writer.implementation;

import it.sevenbits.code_formatter.writer.IWriter;
import it.sevenbits.code_formatter.writer.WriterException;

import java.io.*;

/**
 * Class provides writing to file
 */
public class FileWriter implements IWriter, Closeable {

    private Writer output;

    public FileWriter(String filename) throws WriterException {
        try {
            output = new java.io.FileWriter(new File(filename));
        } catch (IOException e) {
            throw new WriterException(e);
        }

    }

    public void write(int b) throws WriterException {
        try {
            output.write(b);
            output.flush();
        } catch (IOException e) {
            throw new WriterException(e);
        }

    }

    public void close() throws IOException {
        output.close();
    }
}
