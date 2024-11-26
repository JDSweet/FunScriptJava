import com.fun.script.ast.Parser;
import com.fun.script.lang.FunScriptContext;
import com.fun.script.lang.FunScriptVal;
import com.fun.script.lexer.LexToken;
import com.fun.script.lexer.Lexer;
import com.fun.script.tokenizer.Tokenizer;

import java.util.ArrayList;
import java.util.HashMap;

public class Main
{
    public static void main(String[] args)
    {
        //String input = "fun var is  <=>= :> ; table hello world d .1.23. .d12{.}[.///]()+- */%";
        String input = "var myVar = 25";
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.setSpecialChars("{}[]()<>+-*/%=.:;");
        Object[] tokens = tokenizer.tokenize(input);
        System.out.println("Tokenizer Debug: Input is (" + input + ") ");
        for(Object token : tokens)
        {
            System.out.println("Raw Token: " + token);
        }

        Lexer lexer = new Lexer();
        ArrayList<LexToken> lexedTokens = lexer.lex(tokens);
        System.out.println("Lexer Debug: Input is ('" + input + "') ");
        for(LexToken token : lexedTokens)
        {
            System.out.println("Lexed Token: ['" + token.rawToken + "', " + token.tokenType.name() + "]");
        }

        FunScriptContext ctxt = new FunScriptContext();
        Parser parser = new Parser();
        parser.parse(input).execute(ctxt);

        FunScriptVal v1 = new FunScriptVal("Hello");
        FunScriptVal v2 = new FunScriptVal("Hello");
        System.out.println(v1.equals(v2));
        System.out.println(new FunScriptVal(tokens[1]).equals(new FunScriptVal("myVar")));
        FunScriptVal var = ctxt.getVariableByName("myVar");
        System.out.println("The value of myVar is " + var.numberVal);

        /*HashMap<FunScriptVal, FunScriptVal> tbl = new HashMap<>();
        tbl.put(new FunScriptVal("myVar"), new FunScriptVal(25.0f));
        System.out.println(tbl.containsKey(new FunScriptVal("myVar")));*/
    }
}