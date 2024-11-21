package com.fun.script.ast.nodes;

import com.fun.script.ast.ParseState;
import com.fun.script.lexer.LexToken;

public class NumberNode extends SyntaxNode
{

    public NumberNode(LexToken tok, ParseState state)
    {
        super(tok, state);
    }

    @Override
    public void execute()
    {
        System.out.println("");
    }
}
