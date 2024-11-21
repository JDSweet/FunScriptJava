import com.fun.script.tokenizer.Tokenizer;

public class Main {
    public static void main(String[] args)
    {
        String input = "hello world d .1.23. .d12{.}[.]()+- */%";
        Tokenizer tokenizer = new Tokenizer();
        Object[] tokens = tokenizer.tokenize(input);
        System.out.println("Tokenizer Debug: Input is (" + input + ") ");
        for(Object token : tokens)
        {
            System.out.println("Token: " + token);
        }
    }
}