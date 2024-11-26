package com.fun.script.ast;

import com.fun.script.FunScript;
import com.fun.script.ast.nodes.*;
import com.fun.script.lexer.LexToken;
import com.fun.script.lexer.Lexer;
import com.fun.script.lexer.TokenType;
import com.fun.script.tokenizer.Tokenizer;

import java.util.ArrayList;


//TODO: Add basic left/right operations (i.e. basic addition, subtraction, multiplication, etc).
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
        RootNode root = new RootNode(null, null, state, this);


        while(state.hasMoreTokens())
        {
            switch(state.cur().tokenType)
            {
                case TokenType.KEY_WORD_VAR: root.addChild(parseVariableDeclStatement(root, state)); break;
                default: //We'll skip over undefined tokens for now.
                    state.incr(1);
            }
            //root.addChild(parseToken(root, state));
        }

        return root;
    }

    public SyntaxNode parseVariableDeclStatement(SyntaxNode root, ParseState state)
    {
        CreateVariableNode retval = new CreateVariableNode(root, null, state, this);
        boolean reachedSemi = false;
        while (state.hasMoreTokens() && state.cur().tokenType != TokenType.SEMI_COLON)
        {
            if(state.cur().tokenType == TokenType.KEY_WORD_VAR)
                state.incr(1);
            if(state.cur().tokenType == TokenType.WORD) {
                retval.addChild(new VariableNameNode(retval, state.cur(), state, this));
                retval.variableName = retval.getChild(0);
                state.incr(1);
            }
            if(state.cur().tokenType == TokenType.EQUALS)
                state.incr(1);
            if(state.cur().tokenType == TokenType.NUMBER)
            {
                retval.addChild(new NumberNode(retval, state.cur(), state, this));
                retval.variableValue = retval.getChild(1);
                state.incr(1);
            }
            //state.incr(1);
        }
        if(state.hasMoreTokens() && state.cur().tokenType == TokenType.SEMI_COLON) {
            reachedSemi = true;
            state.incr(1);
        }
        if(!reachedSemi)
            FunScript.debugLog("Parser.parseVariableDeclStatement()", "FunScriptError: Semi-colon expected!");
        return retval;
    }

    public SyntaxNode readOperationLeft(SyntaxNode parent, ParseState state)
    {
        return null;
    }

    public SyntaxNode readOperationRight(SyntaxNode parent, ParseState state)
    {
        return null;
    }

    //This parses the next token in the stack.
//    public SyntaxNode parseToken(RootNode root, ParseState state)
//    {
//        CreateVariableNode retval = new CreateVariableNode(root, null, state);
//        switch(state.cur().tokenType)
//        {
//            case
//        }
//        return retval;
//    }
}
