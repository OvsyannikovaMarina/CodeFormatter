package it.sevenbits.code_formatter.buffer;

/**
 * Created by marina on 05.07.16.
 */
public interface IBuffer {
    void add(int symbol);
    String getText();
    void clear();
}
