package com.fun.script.ast.nodes;

import com.fun.script.FunScript;
import com.fun.script.ast.ParseState;
import com.fun.script.ast.Parser;
import com.fun.script.lang.FunScriptContext;
import com.fun.script.lexer.LexToken;

import java.util.ArrayList;

public class SyntaxNode
{
    protected SyntaxNode parent;
    protected ArrayList<SyntaxNode> children = new ArrayList<SyntaxNode>();
    protected LexToken tok;

    public SyntaxNode(SyntaxNode parent, LexToken tok, ParseState state, Parser parser)
    {
        this.tok = tok;
        this.parent = parent;
    }

    public void execute(FunScriptContext ctxt)
    {
//        FunScript.debugLog(getClass().getSimpleName() + " Debug", "Evaluating children...");
        for(SyntaxNode child : children)
        {
//            FunScript.debugLog(getClass().getSimpleName() + " Debug", "Evaluating child " + child.getClass().getSimpleName());
            child.execute(ctxt);
        }
//        FunScript.debugLog(getClass().getSimpleName() + " Debug", "Children evaluated.");
    }

    public void addChild(SyntaxNode child)
    {
        this.children.add(child);
    }

    public SyntaxNode getChild(int index)
    {
        return this.children.get(index);
    }
}
