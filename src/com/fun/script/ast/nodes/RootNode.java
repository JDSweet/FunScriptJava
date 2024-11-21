package com.fun.script.ast.nodes;

import com.fun.script.ast.ParseState;
import com.fun.script.lexer.LexToken;

public class RootNode extends SyntaxNode
{
    public RootNode(LexToken tok, ParseState state)
    {
        super(tok, state);
    }

    @Override
    public void execute()
    {
        for(SyntaxNode child : children)
        {
            System.out.println("Executing..." + child);
            if(child != null)
                child.execute();
        }
    }
}
