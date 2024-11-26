package com.fun.script.ast.nodes.functions;

import com.fun.script.ast.ParseState;
import com.fun.script.ast.Parser;
import com.fun.script.ast.nodes.SyntaxNode;
import com.fun.script.lexer.LexToken;

public class FunScriptFuncNode extends SyntaxNode
{
    public int OOP_PRIORITY;

    public FunScriptFuncNode(SyntaxNode parent, LexToken tok, ParseState state, Parser parser)
    {
        super(parent, tok, state, parser);
    }
}
