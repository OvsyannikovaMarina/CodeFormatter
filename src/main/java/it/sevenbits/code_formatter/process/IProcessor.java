package it.sevenbits.code_formatter.process;

import it.sevenbits.code_formatter.reader.IReader;
import it.sevenbits.code_formatter.writer.IWriter;

/**
 * Created by marina on 05.07.16.
 */
public interface IProcessor {
    void process(IWriter writer);
}
