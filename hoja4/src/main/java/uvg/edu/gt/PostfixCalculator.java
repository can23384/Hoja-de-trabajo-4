
import java.util.Stack;


/**
 * La clase PostfixCalculator proporciona métodos para evaluar expresiones postfix.
 */
public class PostfixCalculator {
    private static PostfixCalculator instance;
    
    // Constructor privado para asegurar que la clase sea Singleton
    private PostfixCalculator() {}
    
    /**
     * Obtiene la única instancia de PostfixCalculator (patrón Singleton).
     * @return la instancia única de PostfixCalculator.
     */
    public static PostfixCalculator getInstance() {
        if (instance == null) {
            instance = new PostfixCalculator();
        }
        return instance;
    }
    
    /**
     * Evalúa una expresión postfix y devuelve el resultado.
     * @param expression la expresión postfix a ser evaluada.
     * @return el resultado de la evaluación de la expresión.
     * @throws IllegalArgumentException si la expresión postfix es inválida o incompleta.
     * @throws ArithmeticException si se produce una división por cero durante la evaluación.
     */
    public double evaluate(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");
        
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double operand2;
                double operand1;
                
                try {
                    operand2 = stack.pop();
                    operand1 = stack.pop();
                } catch (Exception e) {
                    throw new IllegalArgumentException("Insufficient operands for operation");
                }
                
                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        if (operand2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }
        
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression format");
        }
        
        return stack.pop();
    }
    
    // Método auxiliar para verificar si una cadena es numérica
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}