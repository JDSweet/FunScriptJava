package com.fun.script.ast.nodes;

import com.fun.script.FunScript;
import com.fun.script.ast.ParseState;
import com.fun.script.ast.Parser;
import com.fun.script.lang.FunScriptContext;
import com.fun.script.lang.FunScriptVal;
import com.fun.script.lexer.LexToken;
import com.fun.script.lexer.TokenType;

public class CreateVariableNode extends SyntaxNode
{
    public SyntaxNode variableName;
    public SyntaxNode variableValue;

    // [0] the variable, [1] the equal sign, [2] the value it is being assigned to.
    public CreateVariableNode(SyntaxNode parent, LexToken tok, ParseState state, Parser parser)
    {
        super(parent, tok, state, parser);
//        if(state.cur().tokenType == TokenType.KEY_WORD_VAR)
//            state.incr(1);
//        if(state.cur().tokenType == TokenType.WORD)
//        {
//            this.variableName = new SyntaxNode(this, state.cur(), state);
//            children.add(variableName);
//            state.incr(1);
//        }
//        if(state.cur().tokenType == TokenType.EQUALS)
//            state.incr(1);
//        if(state.cur().tokenType == TokenType.NUMBER)
//        {
//            this.variableValue = new NumberNode(this, state.cur(), state);
//            state.incr(1);
//        }
    }

    @Override
    public void execute(FunScriptContext ctxt)
    {
        super.execute(ctxt);
        FunScript.debugLog("CreateVariableNode.execute()", "Variable " + variableName.tok.rawToken + " being created...");
        if(this.variableValue.tok.tokenType == TokenType.NUMBER)
            ctxt.addVariable(new FunScriptVal(variableName.tok.rawToken), new FunScriptVal(((NumberNode)variableValue).number));
        FunScript.debugLog("CreateVariableNode.execute()", "The variable " + this.variableName.tok.rawToken + " exists and should be assigned to " + this.variableValue.tok.rawToken);
    }
}
