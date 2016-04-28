package it.sevenbits.code_formatter.reader.implementation;

import it.sevenbits.code_formatter.reader.IReader;
import it.sevenbits.code_formatter.reader.ReaderException;

import java.io.*;

/**
 * Class provides reading from file
 */
public class FileReader implements IReader, Closeable{

    private Reader file_reader;

    public FileReader(String filename) throws ReaderException {
        try{
            file_reader = new java.io.FileReader(new File(filename));
        }catch (FileNotFoundException e) {
            throw new ReaderException(e);
        }
    }

    public int read() throws ReaderException {
        try{
            return file_reader.read();
        } catch (IOException e) {
            throw new ReaderException(e);
        }

    }

    public void close() throws IOException {
        file_reader.close();
    }
}
//AndreyKolyanov
//чт 5, 12