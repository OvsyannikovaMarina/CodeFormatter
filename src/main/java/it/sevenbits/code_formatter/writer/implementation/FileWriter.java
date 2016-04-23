package it.sevenbits.code_formatter.writer.implementation;

import it.sevenbits.code_formatter.writer.IWriter;

import java.io.*;

/**
 * Created by marina on 21.04.16.
 */
public class FileWriter implements IWriter{

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
}
