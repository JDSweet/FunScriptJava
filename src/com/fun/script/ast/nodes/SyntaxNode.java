package com.fun.script.ast.nodes;

import com.fun.script.ast.ParseState;
import com.fun.script.lang.FunScriptContext;
import com.fun.script.lexer.LexToken;

import java.util.ArrayList;

public class SyntaxNode
{
    protected SyntaxNode parent;
    protected ArrayList<SyntaxNode> children = new ArrayList<SyntaxNode>();
    protected LexToken tok;

    public SyntaxNode(SyntaxNode parent, LexToken tok, ParseState state)
    {
        this.tok = tok;
        this.parent = parent;
    }

    public void execute(FunScriptContext ctxt)
    {
        for(SyntaxNode child : children)
        {
            child.execute(ctxt);
        }
    }

    public void addChild(SyntaxNode child)
    {
        this.children.add(child);
    }
}
