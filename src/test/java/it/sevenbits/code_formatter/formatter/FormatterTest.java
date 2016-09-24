package it.sevenbits.code_formatter.formatter;

import it.sevenbits.code_formatter.reader.implementation.StringReader;
import it.sevenbits.code_formatter.writer.implementation.StringWriter;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertEquals;

/**
 * Test class
 */
public class FormatterTest {

    private Formatter formatter;

    @Before
    public void setUp() throws Exception {
        this.formatter = new Formatter();

    }

    @Test
    public void testOpenBraceOnly() throws Exception {
        StringReader testString = new StringReader("{");
        StringWriter actual = new StringWriter();
        String expected = "{\n";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with '{'", expected, actual.toString());
    }

    @Test
    public void testCloseBraceOnly() throws Exception {
        StringReader testString = new StringReader("}");
        StringWriter actual = new StringWriter();
        String expected = "}\n";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with '}'", expected, actual.toString());
    }

    @Test
    public void testSemicolonOnly() throws Exception {
        StringReader testString = new StringReader(";");
        StringWriter actual = new StringWriter();
        String expected = ";\n";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with ';'", expected, actual.toString());
    }

    @Test
    public void testRightFramedCodeWithSingleBraces() throws Exception {
        StringReader testString = new StringReader("while (x == 0) {\n    print (x) ;\n}");
        StringWriter actual = new StringWriter();
        String expected = "while (x == 0) {\n    print (x) ;\n}\n";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with right framed code with single braces", expected, actual.toString());
    }

    @Test
    public void testRightFramedCodeWithDoubleBraces() throws Exception {
        String example = "int f (int index) {if (index > 0) {}}";
        StringReader testString = new StringReader(example);
        StringWriter actual = new StringWriter();
        String expected = "int f (int index) {\n    if (index > 0) {\n    }\n}\n";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with right framed code with double braces", expected, actual.toString());
    }

    @Test
    public void test7RedundantSpaces() throws Exception {
        String example = "int f(int index)        {\n print (x) ;\n}\n";
        StringReader testString = new StringReader(example);
        StringWriter actual = new StringWriter();
        String expected = "int f (int index) {\n    print (x) ;\n}\n";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with redundant spaces", expected, actual.toString());
    }

    @Test
    public void test3RedundantNewline() throws Exception {
        StringReader testString = new StringReader("while (x == 0) {\n\n\n\n    print (x) ;\n}");
        StringWriter actual = new StringWriter();
        String expected = "while (x == 0) {\n    print (x) ;\n}\n";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with redundant newlines", expected, actual.toString());
    }

    @Test
    public void testSpacesAroundOpeningParenthesis() throws Exception {
        String example = "int f(int index) ";
        StringReader testString = new StringReader(example);
        StringWriter actual = new StringWriter();
        String expected = "int f (int index) ";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with spaces around opening parenthesis", expected, actual.toString());
    }

    @Test
    public void testSpacesAroundClosingParenthesis() throws Exception {
        String example = "int f (int index)";
        StringReader testString = new StringReader(example);
        StringWriter actual = new StringWriter();
        String expected = "int f (int index) ";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with spaces around closing parenthesis", expected, actual.toString());
    }

    @Test
    public void testSpacesAroundSingleArithmeticSymbols() throws Exception {
        String example = "x+y";
        StringReader testString = new StringReader(example);
        StringWriter actual = new StringWriter();
        String expected = "x + y";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with spaces around single arithmetic symbols", expected, actual.toString());
    }

    @Test
    public void testSpacesAroundSingleLogicalSymbol() throws Exception {
        String example = "if (x>0) ";
        StringReader testString = new StringReader(example);
        StringWriter actual = new StringWriter();
        String expected = "if (x > 0) ";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with spaces around single logical symbols", expected, actual.toString());
    }

    @Test
    public void testSpacesAroundGreaterOrEquals() throws Exception {
        String example = "if ( x>=0 ) ";
        StringReader testString = new StringReader(example);
        StringWriter actual = new StringWriter();
        String expected = "if ( x >= 0 ) ";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with spaces around composite logical symbols", expected, actual.toString());
    }

    @Test
    public void testSpacesAroundShortOr() throws Exception {
        String example = "()||() ";
        StringReader testString = new StringReader(example);
        StringWriter actual = new StringWriter();
        String expected = "() || () ";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with spaces around composite logical symbols", expected, actual.toString());
    }

    @Test
    public void testSpacesAroundShortAnd() throws Exception {
        String example = "()&&() ";
        StringReader testString = new StringReader(example);
        StringWriter actual = new StringWriter();
        String expected = "() && () ";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with spaces around composite logical symbols", expected, actual.toString());
    }

    @Test
    public void testSpacesAroundAnd() throws Exception {
        String example = "()&() ";
        StringReader testString = new StringReader(example);
        StringWriter actual = new StringWriter();
        String expected = "() & () ";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with spaces around composite logical symbols", expected, actual.toString());
    }

    @Test
    public void testSpacesAroundOr() throws Exception {
        String example = "()|() ";
        StringReader testString = new StringReader(example);
        StringWriter actual = new StringWriter();
        String expected = "() | () ";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with spaces around composite logical symbols", expected, actual.toString());
    }

    @Test
    public void testInsertSpaceBeforeOpeningBrace() throws Exception {
        StringReader testString = new StringReader("if (true){\n    ");
        StringWriter actual = new StringWriter();
        String expected = "if (true) {\n    ";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with '}'", expected, actual.toString());
    }

    @Test
    public void testInsertSpacesBetweenNewlineAndClosingBrace() throws Exception {
        StringReader testString = new StringReader("if (true){\n}\n");
        StringWriter actual = new StringWriter();
        String expected = "if (true) {\n}\n";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with '}'", expected, actual.toString());
    }

    @Test
    public void testInsertSpaceBeforeOpenBrace() throws Exception {
        StringReader testString = new StringReader("try{\n    ");
        StringWriter actual = new StringWriter();
        String expected = "try {\n    ";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with '{'", expected, actual.toString());
    }

    @Test
    public void testInsertSpaceAroundAssignment() throws Exception {
        StringReader testString = new StringReader("x=y");
        StringWriter actual = new StringWriter();
        String expected = "x = y";
        this.formatter.format(testString, actual);
        assertEquals("wrong working with '='", expected, actual.toString());
    }

    @Test(expected = FormatterException.class)
    public void testFormatterException() throws Exception {
        StringReader testString = new StringReader("x=y");
        StringWriter actual = null;
        this.formatter.format(testString, actual);
        fail("Trying to write to null output!");
    }
}