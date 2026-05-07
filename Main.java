package malayalam;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);
        Interpreter interpreter = new Interpreter();
        String complierName="MalayalamScript";

        System.out.println("--- Welcome to the " + complierName + " Compiler ---");
        System.out.println("Type your code (e.g., 'orkku x = 10') or type 'exit' to quit.");

        while (true) {
            System.out.print(">> ");
            String line = consoleInput.nextLine();

            if (line.equalsIgnoreCase("exit")) {
                System.out.println("Nanni!");
                break;
            }

            if (line.trim().isEmpty()) continue;

            try {
                Lexer lexer = new Lexer(line);
                List<Token> tokens = lexer.scanTokens();
                interpreter.interpret(tokens);
            } catch (Exception e) {
                System.err.println("Pizhavu (Error): " + e.getMessage());
            }
        }
        consoleInput.close();
    }
}