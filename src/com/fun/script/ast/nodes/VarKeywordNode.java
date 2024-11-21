package com.fun.script.ast.nodes;

import com.fun.script.ast.ParseState;
import com.fun.script.lexer.LexToken;
import com.fun.script.lexer.TokenType;

public class VarKeywordNode extends SyntaxNode
{
    // A variable declaration is going to look for a word and a '=' next.
    // In FunScript, you MUST assign a variable a value at
    // the time of its declaration (even if that value is null).

    public VarKeywordNode(LexToken tok, ParseState state)
    {
        super(tok, state);
        state.incr(1);
        System.out.println(state.cur().tokenType.name());
        if(state.hasMoreTokens())
        {
            if(state.cur().tokenType == TokenType.WORD)
            {
                addChild(new WordNode(state.cur(), state));
                state.incr(1);
                if(state.hasMoreTokens())
                {
                    if(state.cur().tokenType == TokenType.EQUALS)
                    {
                        addChild(new AssignmentOpNode(state.cur(), state));
                        state.incr(1);
                    }
                }
            }
        }
    }

    @Override
    public void execute()
    {
        System.out.println("Declaring variable...");
        super.execute();
    }
}
