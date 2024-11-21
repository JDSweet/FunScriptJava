import com.fun.script.lexer.LexToken;
import com.fun.script.lexer.Lexer;
import com.fun.script.tokenizer.Tokenizer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        String input = "hello world d .1.23. .d12{.}[.///]()+- */%";
        Tokenizer tokenizer = new Tokenizer();
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
    }
}