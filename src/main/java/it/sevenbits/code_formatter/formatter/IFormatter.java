package it.sevenbits.code_formatter.formatter;

import it.sevenbits.code_formatter.reader.IReader;
import it.sevenbits.code_formatter.writer.IWriter;

import java.io.IOException;

/**
 * Interface for formatting classes
 */
public interface IFormatter {
    void format(IReader input, IWriter output) throws IOException;
}
