package malayalam;

import java.util.*;

public class Lexer {
    private final String source;
    private final Map<String, TokenType> keywords = new HashMap<>();

    public Lexer(String source) {
        this.source = source;
        keywords.put("orkku", TokenType.ORKKU);
        keywords.put("parayu", TokenType.PARAYU);
    }

    public List<Token> scanTokens() {
        List<Token> tokens = new ArrayList<>();
        String[] parts = source.split("\\s+"); // Splits by whitespace

        for (String part : parts) {
            if (keywords.containsKey(part)) {
                tokens.add(new Token(keywords.get(part), part, null));
            } 
            else if (part.equals("+"))
            	tokens.add(new Token(TokenType.PLUS, "+", null));
            else if (part.equals("-")) 
            	tokens.add(new Token(TokenType.MINUS, "-", null));
            else if (part.equals("*"))
            	tokens.add(new Token(TokenType.STAR, "*", null));
            else if (part.equals("/")) 
            	tokens.add(new Token(TokenType.SLASH, "/", null));
            else if (part.equals("=")) {
                tokens.add(new Token(TokenType.EQUALS, "=", null));
            } else if (part.matches("\\d+")) {
                tokens.add(new Token(TokenType.NUMBER, part, Integer.parseInt(part)));
            } else {
                tokens.add(new Token(TokenType.IDENTIFIER, part, null));
            }
        }
        tokens.add(new Token(TokenType.EOF, "", null));
        return tokens;
    }
}