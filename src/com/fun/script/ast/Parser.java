package com.fun.script.ast;

import com.fun.script.FunScript;
import com.fun.script.ast.nodes.CreateVariableNode;
import com.fun.script.ast.nodes.RootNode;
import com.fun.script.ast.nodes.SyntaxNode;
import com.fun.script.lexer.LexToken;
import com.fun.script.lexer.Lexer;
import com.fun.script.lexer.TokenType;
import com.fun.script.tokenizer.Tokenizer;

import java.util.ArrayList;

public class Parser
{
    //Returns the root execution node for this script.
    public SyntaxNode parse(String src)
    {
        //Tokenize our text...
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.setSpecialChars("{}[]()<>+-*/%=.:;");
        Object[] rawTokens = tokenizer.tokenize(src);

        //Now, we need to lex our tokens (give them some extra context info).
        Lexer lexer = new Lexer();
        ArrayList<LexToken> tokens = lexer.lex(rawTokens);

        //Next, we're going to create our internal state.
        ParseState state = new ParseState(tokens.toArray(new LexToken[1]));
        RootNode root = new RootNode(null, null, state);
        while(state.hasMoreTokens())
        {
//            LexToken lexToken = state.cur();
//            FunScript.debugLog("Parser", "LexToken " + lexToken.rawToken + " being added to root.");
//            root.addChild(parseToken(root, lexToken, state));
//            state.incr(1);
            root.addChild(parseToken(root, state.cur(), state));
        }

        return root;
    }

    //This parses the next token in the stack.
    public SyntaxNode parseToken(RootNode root, LexToken token, ParseState state)
    {
        SyntaxNode retval = null;

        switch(token.tokenType)
        {
            case TokenType.KEY_WORD_VAR: retval = new CreateVariableNode(root, token, state); break;
        }

        return retval;
    }
}
