package com.fun.script.lexer;

public class LexState
{
    public int pos;
    public int len;
    public String[] rawTokens;

    public LexState(int pos, int len, Object[] rawTokens)
    {
        this.pos = pos;
        this.len = len;
        this.rawTokens = new String[len];
        for(int i = 0; i < len; i++)
            this.rawTokens[i] = (String)rawTokens[i];
    }
}
