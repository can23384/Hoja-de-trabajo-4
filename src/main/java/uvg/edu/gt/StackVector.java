import java.util.Stack;
import java.util.Vector;

public class StackVector {
    public static String StackVector(String expression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Eliminar '(' del stack
            } else { // Operador encontrado
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        
        // Agregar cualquier operador restante en el stack al resultado
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        
        return postfix.toString();
    }
    
    // Función para obtener la precedencia de un operador
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1; // Operador inválido
        }
    }
    
    public static void main(String[] args) {
        String infixExpression = "a+b*c";
        String StackVector = StackVector(infixExpression);
        System.out.println("Expresión infix: " + infixExpression);
        System.out.println("Expresión postfix: " + StackVector);
    }
}