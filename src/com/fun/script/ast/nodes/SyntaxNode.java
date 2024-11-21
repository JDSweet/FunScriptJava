package com.fun.script.ast.nodes;

import com.fun.script.ast.ParseState;
import com.fun.script.lexer.LexToken;

import java.util.ArrayList;

public class SyntaxNode
{
    protected ArrayList<SyntaxNode> children = new ArrayList<SyntaxNode>();
    protected LexToken tok;

    public SyntaxNode(LexToken tok, ParseState state)
    {
        this.tok = tok;
    }

    public void execute()
    {
        for(SyntaxNode child : children)
        {
            child.execute();
        }
    }

    public void addChild(SyntaxNode child)
    {
        this.children.add(child);
    }
}
