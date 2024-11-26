package com.fun.script.ast.nodes;

import com.fun.script.ast.ParseState;
import com.fun.script.lang.FunScriptContext;
import com.fun.script.lexer.LexToken;

public class NumberNode extends SyntaxNode
{
    public float number = 0.0f;

    public NumberNode(SyntaxNode parent, LexToken tok, ParseState state)
    {
        super(parent, tok, state);
        this.number = Float.parseFloat(this.tok.rawToken);
        //state.incr(100);
    }

    @Override
    public void execute(FunScriptContext ctxt)
    {
        System.out.println("Number " + tok.rawToken);
    }
}
