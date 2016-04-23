package it.sevenbits.code_formatter.main;

import it.sevenbits.code_formatter.reader.IReader;
import it.sevenbits.code_formatter.reader.implementation.*;
import it.sevenbits.code_formatter.reader.implementation.FileReader;
import it.sevenbits.code_formatter.reader.implementation.StringReader;
import it.sevenbits.code_formatter.writer.IWriter;
import it.sevenbits.code_formatter.writer.implementation.*;

import java.io.IOException;

import static it.sevenbits.code_formatter.formatter.implementation.Formatter.format;

/**
 * Created by marina on 19.04.16.
 */
public class Main {

    private Main() {

    }

    public static void main(final String[] args) throws IOException {

        IReader fileIn = new FileReader("input.txt");
        IWriter fileOut = new FileWriter("output.txt");
        format(fileIn, fileOut);


        String s_code = "while(x==0){print(x);}";
        IReader stringIn = new StringReader(s_code);
        IWriter stringOut = new StringWriter();
        format(stringIn, stringOut);
        stringOut.print();
    }
}
