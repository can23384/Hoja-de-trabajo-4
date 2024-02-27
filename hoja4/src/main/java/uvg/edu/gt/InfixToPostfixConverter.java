
import java.util.Stack;


/**
 * La clase InfixToPostfixConverter convierte expresiones infix a postfix.
 */
public class InfixToPostfixConverter {
    private StackInterface stack;

    /**
     * Construye un nuevo InfixToPostfixConverter con la pila especificada.
     * @param stack la pila a utilizar para la conversión.
     */
    public InfixToPostfixConverter(StackInterface stack) {
        this.stack = stack;
    }

    /**
     * Convierte una expresión infix a postfix.
     * @param expression la expresión infix a convertir.
     * @return la expresión en formato postfix.
     * @throws NullPointerException si la expresión es nula.
     */
    public String infixToPostfix(String expression) {
        StringBuilder postfix = new StringBuilder();

        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c).append(" "); // Agregar un espacio después de cada operando
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" "); // Agregar un espacio después de cada operador
                }
                stack.pop(); // Eliminar '(' del stack
            } else { // Operador encontrado
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" "); // Agregar un espacio después de cada operador
                }
                stack.push(c);
            }
        }

        // Agregar cualquier operador restante en el stack al resultado
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" "); // Agregar un espacio después de cada operador
        }

        return postfix.toString().trim(); // Eliminar el espacio en blanco adicional al final y devolver
    }

    /**
     * Obtiene la precedencia de un operador.
     * @param operator el operador del cual se desea obtener la precedencia.
     * @return la precedencia del operador.
     */
    private int precedence(char operator) {
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
}