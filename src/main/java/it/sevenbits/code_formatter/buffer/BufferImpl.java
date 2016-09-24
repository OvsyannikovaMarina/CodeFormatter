package it.sevenbits.code_formatter.buffer;

/**
 * Created by marina on 05.07.16.
 */
public class BufferImpl implements IBuffer {

    private StringBuffer buf = new StringBuffer();

    public void add(int symbol) {
        buf.append((char)symbol);
    }

    public String getText() {
        return buf.toString();
    }

    public void clear() {
        buf.delete(0,buf.length());
    }
}
