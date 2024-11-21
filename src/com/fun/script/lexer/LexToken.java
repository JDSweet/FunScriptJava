package com.fun.script.lexer;

public class LexToken
{
    public String rawToken;
    public TokenType tokenType;

    public LexToken(String rawToken, TokenType tt)
    {
        this.rawToken = rawToken;
        this.tokenType = tt;
    }

    @Override
    public String toString()
    {
        return rawToken;
    }
}
