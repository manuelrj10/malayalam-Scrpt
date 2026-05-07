package malayalam;

import java.util.*;

public class Interpreter {
    private final Map<String, Object> memory = new HashMap<>();

    public void interpret(List<Token> tokens) {
        for (int i = 0; i < tokens.size(); i++) {
            Token t = tokens.get(i);

            if (t.type == TokenType.ORKKU) {
                String varName = tokens.get(++i).lexeme; 
                i++; 
                
               
                int result = resolveValue(tokens.get(++i));

                
                if (i + 1 < tokens.size() && isOperator(tokens.get(i + 1).type)) {
                    TokenType operator = tokens.get(++i).type;
                   
                    int secondValue = resolveValue(tokens.get(++i));

                    if (operator == TokenType.PLUS) result += secondValue;
                    else if (operator == TokenType.MINUS) result -= secondValue;
                    else if (operator == TokenType.STAR) result *= secondValue;
                    else if (operator == TokenType.SLASH) result /= secondValue;
                }

                memory.put(varName, result);
            } 
            else if (t.type == TokenType.PARAYU) {
                String varName = tokens.get(++i).lexeme;
                System.out.println(memory.getOrDefault(varName, "Pizhavu: Undefined variable " + varName));
            }
        }
    }

   
    private int resolveValue(Token token) {
        if (token.type == TokenType.NUMBER) {
            return (int) token.value;
        } else if (token.type == TokenType.IDENTIFIER) {
            if (memory.containsKey(token.lexeme)) {
                return (int) memory.get(token.lexeme);
            } else {
                throw new RuntimeException("Variable '" + token.lexeme + "' not found!");
            }
        }
        return 0;
    }

    private boolean isOperator(TokenType type) {
        return type == TokenType.PLUS || type == TokenType.MINUS || 
               type == TokenType.STAR || type == TokenType.SLASH;
    }
}