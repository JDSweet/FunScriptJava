package com.fun.script.ast.nodes.functions;

import com.fun.script.ast.ParseState;
import com.fun.script.ast.Parser;
import com.fun.script.ast.nodes.NumberNode;
import com.fun.script.ast.nodes.SyntaxNode;
import com.fun.script.lexer.LexToken;

/*
*
* P - Parentheses - 1
* E - Exponents - 2
* M - Multiplication - 3
* D - Division - 4
* A - Addition - 5
* S - Subtraction - 5
*
* */
public class AddFunctionNode extends FunScriptFuncNode
{
    public NumberNode left;
    public NumberNode right;

    //The add function consists of everything to the left and the right of
    public AddFunctionNode(SyntaxNode parent, LexToken tok, ParseState state, Parser parser)
    {
        super(parent, tok, state, parser);

        this.left = (NumberNode)parser.readOperationLeft(this, state);
        this.right = (NumberNode)parser.readOperationRight(this, state);
        this.addChild(left);
        this.addChild(right);
    }
}
