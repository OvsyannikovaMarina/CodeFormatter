package it.sevenbits.code_formatter.formatter;

import it.sevenbits.code_formatter.reader.IReader;
import it.sevenbits.code_formatter.writer.IWriter;
import it.sevenbits.code_formatter.writer.WriterException;

/**
 * Class provides formatting some code
 */
public class Formatter {

    /**
     * Default constructor
     */
    public Formatter() {

    }

    public void format(IReader input, IWriter output) throws FormatterException {
        final int numberOfSpaces = 4;
        int currentSymbol;
        int lastSymbol = ' ';
        int charCount = 0;

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
                            insertIndent(output, numberOfSpaces, charCount);
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
                            insertIndent(output, numberOfSpaces, charCount);
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
                            insertIndent(output, numberOfSpaces, charCount);
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

    private static void insertIndent(IWriter output, int numberOfSpaces, int charCount) throws WriterException {
        for (int i = 0; i < charCount * numberOfSpaces; i++) {
            output.write(' ');
        }
    }
}
