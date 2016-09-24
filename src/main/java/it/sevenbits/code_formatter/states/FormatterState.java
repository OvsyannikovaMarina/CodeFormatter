package it.sevenbits.code_formatter.states;

/**
 * Created by marina on 05.07.16.
 */
public class FormatterState {
    private FormatterState(){}

    public static final FormatterState BRACE_STATE = new FormatterState();
    public static final FormatterState DEFAULT_STATE = new FormatterState();
    public static final FormatterState SIMPLE_COMMENT_STATE = new FormatterState();
    public static final FormatterState BIG_COMMENT_STATE = new FormatterState();

}
