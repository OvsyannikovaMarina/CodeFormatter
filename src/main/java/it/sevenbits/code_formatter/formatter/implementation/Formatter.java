package it.sevenbits.code_formatter.formatter.implementation;

import it.sevenbits.code_formatter.reader.IReader;
import it.sevenbits.code_formatter.writer.IWriter;

import java.io.IOException;

/**
 * Created by marina on 21.04.16.
 */
public class Formatter {

    private Formatter() {

    }

    public static void format(IReader input, IWriter output) throws IOException {
        final int numberOfSpaces = 4;
        int currentSymbol;
        int lastSymbol = ' ';
        int charCount = 0;

        while ((currentSymbol = input.read()) != -1) {
            switch (currentSymbol) {
                case '{' : {
                    charCount++;
                    if (lastSymbol != ' '){
                        output.write(' ');
                    }
                    output.write('{');
                    output.write('\n');
                    for (int i = 0; i < charCount * numberOfSpaces; i++) {
                        output.write(' ');
                    }
                    break;
                }

                case '}': {
                    if (charCount > 0) {
                        charCount--;
                    }
                    if ((lastSymbol != '}') && (lastSymbol != ';')) {
                        output.write('\n');
                        for (int i = 0; i < charCount * numberOfSpaces; i++) {
                            output.write(' ');
                        }
                    }
                    output.write('}');
                    output.write('\n');
                    for (int i = 0; i < charCount * numberOfSpaces; i++) {
                        output.write(' ');
                    }
                    break;
                }

                case ';': {
                    if (charCount > 0) {
                        charCount--;
                    }
                    output.write(';');
                    output.write('\n');
                    for (int i = 0; i < charCount * numberOfSpaces; i++) {
                        output.write(' ');
                    }
                    break;
                }

                default: {
                    /*if((lastSymbol == ';') || (lastSymbol == '}') || (lastSymbol == '{')) {
                        if (currentSymbol == ' ') {
                            currentSymbol = lastSymbol;
                            break;
                        }
                    }*/
                    output.write(currentSymbol);
                    break;
                }
            }
            lastSymbol = currentSymbol;
        }
    }
}
