package com.fun.script.lexer;

import java.util.ArrayList;

public class Lexer
{
    public ArrayList<LexToken> lex(Object[] rawTokens)
    {
        ArrayList<LexToken> tokens = new ArrayList<LexToken>();
        LexState state = new LexState(0, rawTokens.length, rawTokens);
        for(String rawToken : state.rawTokens)
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
            case "null": tt = TokenType.KEY_WORD_NULL; break;
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
            case "or": tt = TokenType.KEY_WORD_OR; break;
            case "not": tt = TokenType.KEY_WORD_NOT; break;
            case ">": tt = TokenType.GREATER_THAN; break;
            case "<": tt = TokenType.LESSER_THAN; break;
            default:
                if(Character.isDigit(rawToken.charAt(0)))
                {
                    if(validateNumber(rawToken))
                        tt = TokenType.NUMBER;
                    else
                        tt = TokenType.INVALID;
                }
                else if(Character.isAlphabetic(rawToken.charAt(0)))
                {
                    tt = TokenType.WORD;
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

            if(rawToken.charAt(i) == '.')
            {
                //If the last character is a dot, then this is not a valid number.
                // (because a dot must always be preceded and followed by at least one digit).
                if(i == rawToken.length() - 1)
                    isValidNumber = false;
                // If the first character is a dot, then this is not a valid number
                // (because the dot must always be preceded and followed by at least one digit).
                else if(i == 0)
                    isValidNumber = false;
                else
                    continue;
            }
            // If the character is otherwise a digit, we are still a valid number. Only '.' and
            // digits are valid parts of a number.
            if(!Character.isDigit(rawToken.charAt(i)))
                return false;

        }
        return isValidNumber;
    }
}
