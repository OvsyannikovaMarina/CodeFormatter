package it.sevenbits.code_formatter.writer;

import java.io.IOException;

/**
 * Interface for writing classes
 */
public interface IWriter {
    void write(int b) throws IOException;
}
