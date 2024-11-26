package com.fun.script.ast.nodes;

import com.fun.script.ast.ParseState;
import com.fun.script.ast.Parser;
import com.fun.script.lexer.LexToken;

public class VariableNameNode extends SyntaxNode
{
    public String variableName;

    public VariableNameNode(SyntaxNode parent, LexToken tok, ParseState state, Parser parser)
    {
        super(parent, tok, state, parser);
        this.variableName = tok.rawToken;
    }
}
