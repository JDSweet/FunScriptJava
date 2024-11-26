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
        boolean debuggingTokenizer = false;
        boolean debuggingLexer = false;
        boolean debuggingParser = true;

        //String input = "fun var is  <=>= :> ; table hello world d .1.23. .d12{.}[.///]()+- */%";
        String input =
                "var myVar = 25 " +
                "var myVar2 = 28 " +
                "var myVar3 = 29 " +
                "var myVar4 = 30 " +
                "var myVar5 = 31";


        if(debuggingTokenizer)
        {
            Tokenizer tokenizer = new Tokenizer();
            tokenizer.setSpecialChars("{}[]()<>+-*/%=.:;");
            Object[] tokens = tokenizer.tokenize(input);
            System.out.println("Tokenizer Debug: Input is (" + input + ") ");
            for(Object token : tokens)
            {
                System.out.println("Raw Token: " + token);
            }
        }

        if(debuggingLexer)
        {
            Tokenizer tokenizer = new Tokenizer();
            tokenizer.setSpecialChars("{}[]()<>+-*/%=.:;");
            Object[] tokens = tokenizer.tokenize(input);
            Lexer lexer = new Lexer();
            ArrayList<LexToken> lexedTokens = lexer.lex(tokens);
            System.out.println("Lexer Debug: Input is ('" + input + "') ");
            for(LexToken token : lexedTokens)
            {
                System.out.println("Lexed Token: ['" + token.rawToken + "', " + token.tokenType.name() + "]");
            }
        }

        if(debuggingParser)
        {
            FunScriptContext ctxt = new FunScriptContext();
            Parser parser = new Parser();
            parser.parse(input).execute(ctxt);
            ctxt.debugGlobalTable();

            /*FunScriptVal v1 = new FunScriptVal("Hello");
            FunScriptVal v2 = new FunScriptVal("Hello");
            System.out.println(v1.equals(v2));*/
            //System.out.println(new FunScriptVal(tokens[1]).equals(new FunScriptVal("myVar")));
            FunScriptVal var1 = ctxt.getVariableByName("myVar");
            FunScriptVal var2 = ctxt.getVariableByName("myVar2");
            FunScriptVal var3 = ctxt.getVariableByName("myVar3");
            FunScriptVal var4 = ctxt.getVariableByName("myVar4");
            FunScriptVal var5 = ctxt.getVariableByName("myVar5");

            System.out.println("The value of myVar is " + var1.numberVal);
            System.out.println("The value of myVar2 is " + var2.numberVal);
            System.out.println("The value of myVar3 is " + var3.numberVal);
            System.out.println("The value of myVar4 is " + var4.numberVal);
            System.out.println("The value of myVar5 is " + var5.numberVal);

            /*HashMap<FunScriptVal, FunScriptVal> tbl = new HashMap<>();
            tbl.put(new FunScriptVal("myVar"), new FunScriptVal(25.0f));
            System.out.println(tbl.containsKey(new FunScriptVal("myVar")));*/
        }

    }
}