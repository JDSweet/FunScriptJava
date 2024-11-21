package com.fun.script.lexer;

import java.util.ArrayList;

public class Lexer
{
    public ArrayList<LexToken> lex(String[] rawTokens)
    {
        ArrayList<LexToken> tokens = new ArrayList<LexToken>();
        LexState state = new LexState(0, rawTokens.length, rawTokens);
        for(String rawToken : rawTokens)
        {
            tokens.add(lex(rawToken));
        }
        return tokens;
    }

    private LexToken lex(String rawToken)
    {
        TokenType tt = TokenType.UNDEFINED;
        switch(rawToken)
        {
            case "fun": tt = TokenType.KEY_WORD_FUN; break;
            case "var": tt = TokenType.KEY_WORD_VAR; break;
            case "table": tt = TokenType.KEY_WORD_TABLE; break;
            case "is": tt = TokenType.KEY_WORD_IS; break;
            case "{": tt = TokenType.OPEN_CURLY; break;
            case "}": tt = TokenType.CLOSE_CURLY; break;
            case "(": tt = TokenType.OPEN_PAREN; break;
            case ")": tt = TokenType.CLOSE_PAREN; break;
            case "[": tt = TokenType.OPEN_BRACKET; break;
            case "]": tt = TokenType.CLOSE_BRACKET; break;
            case "*": tt = TokenType.MULT; break;
            case "+": tt = TokenType.ADD; break;
            case "-": tt = TokenType.SUBT; break;
            case "/": tt = TokenType.DIV; break;
            case "%": tt = TokenType.MOD; break;
            case "=": tt = TokenType.EQUALS; break;
            case ".": tt = TokenType.DOT; break;
            case ":": tt = TokenType.COLON; break;
            case ";": tt = TokenType.SEMI_COLON; break;
            default:
                if(Character.isDigit(rawToken.charAt(0)))
                {

                }
                break;
        }
        return new LexToken(rawToken, tt);
    }

    //It is a valid number if:
    //  1. All characters are digits.
    //  2. There is a dot that is both preceded and followed by at least one digit.
    boolean validateNumber(String rawToken)
    {
        boolean isValidNumber = true;
        for(int i = 0; i < rawToken.length(); i++)
        {
            //If the last character is a dot, then this is not a valid number.
            // (because a dot must always be preceded and followed by at least one digit).
            if(rawToken.charAt(i) == '.' && i == rawToken.length() - 1)
                isValidNumber = false;
            // If the first character is a dot, then this is not a valid number
            // (because the dot must always be preceded and followed by at least one digit).
            if(rawToken.charAt(i) == '.' && i == 0)
                isValidNumber = false;
            //If the rawToken doesn't contain any alphabetic characters, it must be a number.

        }
        return isValidNumber;
    }
}
