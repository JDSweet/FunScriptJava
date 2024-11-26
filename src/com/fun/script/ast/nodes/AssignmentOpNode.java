package com.fun.script.ast.nodes;

import com.fun.script.FunScript;
import com.fun.script.ast.ParseState;
import com.fun.script.lang.FunScriptContext;
import com.fun.script.lang.FunScriptVal;
import com.fun.script.lexer.LexToken;
import com.fun.script.lexer.TokenType;

public class AssignmentOpNode extends SyntaxNode
{

    public AssignmentOpNode(SyntaxNode parent, LexToken tok, ParseState state)
    {
        super(parent, tok, state);
        state.incr(1);
        if(state.hasMoreTokens())
        {
            if(state.cur().tokenType == TokenType.NUMBER)
            {
                addChild(new NumberNode(this, state.cur(), state));
            }
            else if(state.cur().tokenType == TokenType.WORD)
            {
                addChild(new VariableLookupNode(this, state.cur(), state));
            }
        }
    }

    @Override
    public void execute(FunScriptContext ctxt)
    {
        System.out.println("Assigning...");
        //0 because the "=" always expects the previous token to have been the variable name.
        FunScriptVal key = FunScript.coerceJavaToFS(parent.children.get(0).tok.rawToken);
        FunScriptVal val = FunScript.coerceFloatToNumber(((NumberNode)children.get(0)).number);
        System.out.println("Adding variable to context... {" + key.stringVal + ", " + val.numberVal + "}");
        ctxt.addVariable(key, val);
        super.execute(ctxt);
    }
}
