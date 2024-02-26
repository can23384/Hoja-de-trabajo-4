public class InfixToPostfixConverter {
    private StackInterface stack;

    public InfixToPostfixConverter(StackInterface stack) {
        this.stack = stack;
    }

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

    // Función para obtener la precedencia de un operador
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
/*public class InfixToPostfixConverter {
    private StackInterface stack;

    public InfixToPostfixConverter(StackInterface stack) {
        this.stack = stack;
    }

    public String infixToPostfix(String expression) {
        StringBuilder postfix = new StringBuilder();

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
}*/