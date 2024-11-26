package com.fun.script.ast.nodes;

import com.fun.script.ast.ParseState;
import com.fun.script.lexer.LexToken;

public class VariableLookupNode extends SyntaxNode
{
    public VariableLookupNode(SyntaxNode parent, LexToken tok, ParseState state)
    {
        super(parent, tok, state);
    }
}
