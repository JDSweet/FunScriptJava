package com.fun.script.ast.nodes;

import com.fun.script.ast.ParseState;
import com.fun.script.lang.FunScriptContext;
import com.fun.script.lexer.LexToken;
import com.fun.script.lexer.TokenType;

public class VarKeywordNode extends SyntaxNode
{
    // A variable declaration is going to look for a word (its alias) and a '=' next.
    // In FunScript, you MUST assign variables to hold a value at
    // the time of variable declaration (even if that value is null).

    public VarKeywordNode(SyntaxNode parent, LexToken tok, ParseState state)
    {
        super(parent, tok, state);
        state.incr(1);
        System.out.println(state.cur().tokenType.name());
        if(state.hasMoreTokens())
        {
            if(state.cur().tokenType == TokenType.WORD)
            {
                addChild(new VariableNameNode(this, state.cur(), state));
                state.incr(1);
                if(state.hasMoreTokens())
                {
                    if(state.cur().tokenType == TokenType.EQUALS)
                    {
                        addChild(new AssignmentOpNode(this, state.cur(), state));
                        state.incr(1);
                    }
                }
            }
        }
    }

    @Override
    public void execute(FunScriptContext ctxt)
    {
        System.out.println("Declaring variable...");
        super.execute(ctxt);
    }
}
