package com.fun.script.lexer;

public class LexState
{
    public int pos;
    public int len;
    public String[] rawTokens;

    public LexState(int pos, int len, String[] rawTokens)
    {
        this.pos = pos;
        this.len = len;
        this.rawTokens = rawTokens;
    }
}
