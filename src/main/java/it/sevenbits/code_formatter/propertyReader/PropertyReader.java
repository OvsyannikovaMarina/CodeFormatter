package it.sevenbits.code_formatter.propertyReader;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Class for reading parameters of indent (symbol and count)
 */
public class PropertyReader {

    private PropertyReader() {

    }

    public static int readIndentSymbol () throws PropertyException {
        FileInputStream inStream;
        Properties property = new Properties();
        String indentSymbol;

        try {
            inStream = new FileInputStream("src/main/resources/config.properties");
            property.load(inStream);
            indentSymbol = property.getProperty("indent.symbol");
        } catch (Exception e) {
            throw new PropertyException(e);
        }
        return indentSymbol.codePointAt(0);
    }

    public static int readIndentCount () throws PropertyException {
        FileInputStream inStream;
        Properties property = new Properties();
        String indentCount;
        try {
            inStream = new FileInputStream("src/main/resources/config.properties");
            property.load(inStream);
            indentCount = property.getProperty("indent.count");
        } catch (Exception e) {
            throw new PropertyException(e);
        }
        return Integer.parseInt(indentCount);
    }
}
