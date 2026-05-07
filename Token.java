package malayalam;

public class Token {
    public final TokenType type;
    public final String lexeme;
    public final Object value;

    public Token(TokenType type, String lexeme, Object value) {
        this.type = type;
        this.lexeme = lexeme;
        this.value = value;
    }

    @Override
    public String toString() {
        return type + " " + lexeme + (value != null ? " " + value : "");
    }
}