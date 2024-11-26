package com.fun.script.ast.nodes;

import com.fun.script.ast.ParseState;
import com.fun.script.lang.FunScriptContext;
import com.fun.script.lexer.LexToken;

public class RootNode extends SyntaxNode
{
    public RootNode(SyntaxNode parent, LexToken tok, ParseState state)
    {
        super(parent, tok, state);
    }

    @Override
    public void execute(FunScriptContext ctxt)
    {
        super.execute(ctxt);
    }
}
