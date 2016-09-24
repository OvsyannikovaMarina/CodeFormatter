package it.sevenbits.code_formatter.formatter;

import it.sevenbits.code_formatter.propertyReader.PropertyException;
import it.sevenbits.code_formatter.reader.IReader;
import it.sevenbits.code_formatter.states.FormatterState;
import it.sevenbits.code_formatter.writer.IWriter;
import it.sevenbits.code_formatter.writer.WriterException;

import static it.sevenbits.code_formatter.propertyReader.PropertyReader.readIndentCount;
import static it.sevenbits.code_formatter.propertyReader.PropertyReader.readIndentSymbol;

/**
 * Class provides formatting some code
 */
public class Formatter {

    private FormatterState state = FormatterState.DEFAULT_STATE;
    private final int numberOfIndentSymbols;
    private final int indentSymbol;
    private int charCount;
    /**
     * Default constructor
     */
    public Formatter() throws PropertyException {
        numberOfIndentSymbols = readIndentCount();
        indentSymbol = readIndentSymbol();
        charCount = 0;
    }

    public void format(IReader input, IWriter output) throws FormatterException, PropertyException {

        int currentSymbol;
        int lastSymbol = ' ';

        try {
            while ((currentSymbol = input.read()) != -1) {
                switch (currentSymbol) {
                    case '{' : {
                        charCount++;
                        if (lastSymbol != ' ') {
                            output.write(' ');
                        }
                        output.write(currentSymbol);
                        output.write('\n');
                        lastSymbol = '\n';
                        break;
                    }

                    case '}': {
                        if (charCount > 0) {
                            charCount--;
                        }
                        if ((lastSymbol == '\n')) {
                            insertIndent(output, numberOfIndentSymbols, charCount, indentSymbol);
                        }
                        output.write(currentSymbol);
                        output.write('\n');
                        lastSymbol = '\n';
                        break;
                    }

                    case ';': {
                        output.write(currentSymbol);
                        output.write('\n');
                        lastSymbol = '\n';
                        break;
                    }

                    case '\n': {
                        break;
                    }

                    case '(': {
                        if (lastSymbol != ' '){
                            output.write(' ');
                        }
                        output.write(currentSymbol);
                        lastSymbol = currentSymbol;
                        break;
                    }

                    case ')': {
                        output.write(currentSymbol);
                        output.write(' ');
                        lastSymbol = ' ';
                        break;
                    }
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                    case '&':
                    case '|': {
                        if (currentSymbol == lastSymbol) {
                            output.write(currentSymbol);
                            output.write(' ');
                            lastSymbol = ' ';
                            break;
                        } else if (lastSymbol == ' ') {
                            output.write(currentSymbol);
                            lastSymbol = currentSymbol;
                            break;
                        } else {
                            output.write(' ');
                            output.write(currentSymbol);
                            lastSymbol = currentSymbol;
                        }
                        break;
                    }

                    case '<':
                    case '>':
                    case '!': {
                        if (lastSymbol == ' ') {
                            output.write(currentSymbol);
                            lastSymbol = currentSymbol;
                            break;
                        }
                        output.write(' ');
                        output.write(currentSymbol);
                        lastSymbol = currentSymbol;
                        break;
                    }

                    case '=': {
                        if ((lastSymbol == '!') || (lastSymbol == '>') || (lastSymbol == '<')
                                || (lastSymbol == '+') || (lastSymbol == '-') || (lastSymbol == '*')
                                || (lastSymbol == '/') || (lastSymbol == '=')) {
                            output.write(currentSymbol);
                            output.write(' ');
                            lastSymbol = ' ';
                            break;
                        } else if (lastSymbol != ' ') {
                            output.write(' ');
                        }
                        output.write(currentSymbol);
                        lastSymbol = currentSymbol;
                        break;
                    }

                    case ' ': {
                        if (lastSymbol == ' ') {
                            break;
                        }
                        if (lastSymbol == '\n') {
                            insertIndent(output, numberOfIndentSymbols, charCount, indentSymbol);
                            lastSymbol = ' ';
                            break;
                        }
                        output.write(' ');
                        lastSymbol = ' ';
                        break;
                    }

                    default: {
                        if ((lastSymbol == '&') || (lastSymbol == '|') || (lastSymbol == '=')
                                || (lastSymbol == '>') || (lastSymbol == '<') || (lastSymbol == '+')
                                || (lastSymbol == '-') || (lastSymbol == '*') || (lastSymbol == '/')) {
                            output.write(' ');
                        } else if (lastSymbol == '\n') {
                            insertIndent(output, numberOfIndentSymbols, charCount, indentSymbol);
                        }
                        output.write(currentSymbol);
                        lastSymbol = currentSymbol;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new FormatterException(e);
        }

    }

    private static void insertIndent(IWriter output, int numberOfIndentSymbols, int charCount, int indentSymbol) throws WriterException {
        for (int i = 0; i < charCount * numberOfIndentSymbols; i++) {
            output.write(indentSymbol);
        }
    }
}
