package by.it.zaretskaya.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

private VarRepository varRepository;

    public Parser(VarRepository varRepository) {
        this.varRepository = varRepository;
    }

    public Var calc(String expression) {
        expression = expression.replaceAll(Patterns.SPACES,"");
        String[] parts= expression.split(Patterns.OPERATION,2);
        if (parts.length==1){
            return varRepository.create(expression);
        }
        Var right=varRepository.create(parts[1]);
        if (expression.contains("=")){
            String name = parts[0];
            return varRepository.save(name,right);

        }
        Var left=varRepository.create(parts[0]);
        if (left==null|| right==null){
            System.out.println("Incorrect expression"+expression);
            return null;
        }
        Matcher matcher= Pattern.compile(Patterns.OPERATION).matcher(expression);
        if (matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+":return left.add(right);
                case "-":return left.sub(right);
                case "*":return left.mul(right);
                case "/":return left.div(right);
            }

        }
        return null;
    }
}
