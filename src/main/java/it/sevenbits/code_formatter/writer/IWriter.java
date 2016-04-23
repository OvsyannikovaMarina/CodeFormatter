package it.sevenbits.code_formatter.writer;

import java.io.IOException;

/**
 * Created by marina on 20.04.16.
 */
public interface IWriter {
    void write(int b) throws IOException;
    void print();
}
