import java.util.Stack;

public class PostfixCalculator {
    private static PostfixCalculator instance;
    
    private PostfixCalculator() {}
    
    public static PostfixCalculator getInstance() {
        if (instance == null) {
            instance = new PostfixCalculator();
        }
        return instance;
    }
    
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
    
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}