package com.fun.script.tokenizer;

import java.util.ArrayList;

public class Tokenizer
{
    private StringBuilder bldr;
    private char[] specialChars;

    public Tokenizer()
    {
        this.bldr = new StringBuilder();
    }

    public void setSpecialChars(String tChars)
    {
        this.specialChars = tChars.toCharArray();
    }

    public Object[] tokenize(String input)
    {
        TokenizationState state = new TokenizationState();
        ArrayList<String> tokens = new ArrayList<String>();

        //Configure our tokenization state...
        state.src = input.toCharArray();
        state.pos = 0;
        state.len = state.src.length;
        state.curLine = 0;

        //Tokenize the text.
        while (state.pos < state.len)
        {
            tokens.add(nextToken(state));
        }
        return tokens.toArray();
    }

    private String nextToken(TokenizationState state)
    {
        String retval = "EOF";

        //Clear the token builder's buffer.
        bldr.setLength(0);

        //We're gonna skip any whitespace between tokens.
        while(!state.completed() && isWhitespace(state.cur()))
        {
            System.out.println("Skipping Whitespace...");
            if(state.cur() == '\n')
                state.curLine++;
            state.incr(1);
        }

        //If we did not reach the end of the script...
        if(!state.completed())
        {
            if(isAlphaNumeric(state.cur()))
            {
                while (!state.completed() && (isAlphaNumeric(state.cur()) || state.cur() == '.'))
                {
                    if(state.cur() == '.')
                    {
                        if(!Character.isDigit(state.peekNext()))
                        {
                            break;
                        }
                        else bldr.append(state.cur());
                        state.incr(1);
                    }
                    else
                    {
                        bldr.append(state.cur());
                        state.incr(1);
                    }
                }
            }
            else
            {
                //If this is in a special list of tokenizable characters, they are singularly a token of their own.
                if(containsChar(this.specialChars, state.cur()))
                {
                    bldr.append(state.cur());
                    state.incr(1);
                }
            }
        }
        return bldr.toString();
    }

    public boolean isWhitespace(char c)
    {
        return Character.isWhitespace(c);
    }

    public boolean isAlphaNumeric(char c)
    {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }

    private boolean containsChar(char[] list, char c)
    {
        for(int i = 0; i < list.length; i++)
        {
            if(c == list[i])
                return true;
        }
        return false;
    }


    private class TokenizationState
    {
        public int pos;
        public int len;
        public char[] src;
        public int curLine;

        public boolean completed()
        {
            return pos == len;
        }

        public char cur()
        {
            return src[pos];
        }

        public void incr(int amnt)
        {
            this.pos += amnt;
        }

        public char peekNext()
        {
            if(pos+1 < len)
            {
                return this.src[pos+1];
            }
            else return ' ';
        }
    }
}
