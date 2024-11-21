package com.fun.script.ast.nodes;

import com.fun.script.ast.ParseState;
import com.fun.script.lexer.LexToken;
import com.fun.script.lexer.TokenType;

public class AssignmentOpNode extends SyntaxNode
{
    public AssignmentOpNode(LexToken tok, ParseState state)
    {
        super(tok, state);
        state.incr(1);
        if(state.hasMoreTokens())
        {
            if(state.cur().tokenType == TokenType.NUMBER)
            {
                addChild(new NumberNode(state.cur(), state));
            }
            else if(state.cur().tokenType == TokenType.WORD)
            {
                addChild(new WordNode(state.cur(), state));
            }
        }
    }

    @Override
    public void execute()
    {
        System.out.println("Assigning...");
        super.execute();
    }
}
