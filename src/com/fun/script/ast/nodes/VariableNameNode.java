package com.fun.script.ast.nodes;

import com.fun.script.ast.ParseState;
import com.fun.script.lang.FunScriptContext;
import com.fun.script.lexer.LexToken;

public class VariableNameNode extends SyntaxNode
{
    public VariableNameNode(SyntaxNode parent, LexToken tok, ParseState state)
    {
        super(parent, tok, state);
    }

    @Override
    public void execute(FunScriptContext ctxt)
    {
        System.out.println("Variable Name: " + tok.toString());
    }
}
