package it.sevenbits.code_formatter.formatter;

import it.sevenbits.code_formatter.reader.IReader;
import it.sevenbits.code_formatter.writer.IWriter;

import java.io.IOException;

/**
 * Class provides formatting some code
 */
public class Formatter {

    /**
     * Default constructor
     */
    public Formatter() {

    }

    public void format(IReader input, IWriter output) throws IOException {
        final int numberOfSpaces = 4;
        int currentSymbol;
        int lastSymbol = ' ';
        int charCount = 0;

        while ((currentSymbol = input.read()) != -1) {
            switch (currentSymbol) {
                case '{' : {
                    charCount++;
                    if (lastSymbol != ' ') {
                        output.write(' ');
                    }
                    output.write('{');
                    output.write('\n');
                    for (int i = 0; i < charCount * numberOfSpaces; i++) {
                        output.write(' ');
                    }
                    lastSymbol = ' ';
                    break;
                }

                case '}': {
                    if (charCount > 0) {
                        charCount--;
                    }
                    if ((lastSymbol == '\n')) {
                        for (int i = 0; i < charCount * numberOfSpaces; i++) {
                            output.write(' ');
                        }
                    }
                    output.write('}');
                    output.write('\n');
                    lastSymbol = '\n';
                    break;
                }

                case ';': {
                    output.write(';');
                    output.write('\n');
                    lastSymbol = '\n';
                    break;
                }

                default: {
                    if ((currentSymbol == ' ') && (lastSymbol == ' ')) {
                        break;
                    }
                    if ((lastSymbol == '\n') && (currentSymbol == ' ')) {
                        for (int i = 0; i < charCount * numberOfSpaces; i++) {
                            output.write(' ');
                        }
                        lastSymbol = ' ';
                        break;
                    }
                    output.write(currentSymbol);
                    lastSymbol = currentSymbol;
                    break;
                }
            }
        }
    }
}
