package it.sevenbits.code_formatter.main;

import it.sevenbits.code_formatter.formatter.Formatter;
import it.sevenbits.code_formatter.reader.IReader;
import it.sevenbits.code_formatter.reader.implementation.*;
import it.sevenbits.code_formatter.writer.IWriter;
import it.sevenbits.code_formatter.writer.implementation.*;

import java.io.IOException;

/**
 * Main class
 */
public class Main {

    private Main() {
        /**
         * Not called
         */
    }

    /**
     * Entry point
     * @param args arguments
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {

        Formatter newFormatter = new Formatter();

        IReader fileIn = new FileReader("input.txt");
        IWriter fileOut = new FileWriter("output.txt");
        newFormatter.format(fileIn, fileOut);


        String s_code = "while(x==0){print(x);}";
        IReader stringIn = new StringReader(s_code);
        IWriter stringOut = new StringWriter();
        newFormatter.format(stringIn, stringOut);
        System.out.println(stringOut.toString());
    }
}
