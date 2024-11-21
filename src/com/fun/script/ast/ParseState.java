package com.fun.script.ast;

import com.fun.script.lexer.LexToken;

public class ParseState
{
    public int pos, len;
    public LexToken[] src;
    public ParseState(LexToken[] src)
    {
        this.src = src;
        this.pos = 0;
        this.len = src.length;
    }

    public boolean hasMoreTokens()
    {
        return pos < len;
    }

    public LexToken cur()
    {
        return this.src[pos];
    }

    public void incr(int amnt)
    {
        this.pos += amnt;
    }
}
