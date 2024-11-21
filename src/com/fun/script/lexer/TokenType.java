package com.fun.script.lexer;

public enum TokenType
{
    WORD,
    NUMBER,
    EQUALS,
    DOT,
    OPEN_CURLY, CLOSE_CURLY,
    OPEN_PAREN, CLOSE_PAREN,
    OPEN_BRACKET, CLOSE_BRACKET,
    ADD, SUBT, DIV, MULT, MOD,
    COLON, SEMI_COLON,
    KEY_WORD_FUN,
    KEY_WORD_TABLE,
    KEY_WORD_VAR,
    KEY_WORD_IS,
    UNDEFINED,
    INVALID
}
