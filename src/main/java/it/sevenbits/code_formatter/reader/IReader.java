package it.sevenbits.code_formatter.reader;

import java.io.IOException;

/**
 * Interface for reading classes
 */
public interface IReader {
    int read() throws ReaderException;
}
