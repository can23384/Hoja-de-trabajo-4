public class ExpressionEvaluator {
    private StackInterface stack;

    public ExpressionEvaluator(StackInterface stack) {
        this.stack = stack;
    }

    public int evaluatePostfixExpression(String postfixExpression) {
        for (char c : postfixExpression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c);
            } else {
                int operand2 = Character.getNumericValue(stack.pop());
                int operand1 = Character.getNumericValue(stack.pop());
                switch (c) {
                    case '+':
                        stack.push((char) (operand1 + operand2 + '0'));
                        break;
                    case '-':
                        stack.push((char) (operand1 - operand2 + '0'));
                        break;
                    case '*':
                        stack.push((char) (operand1 * operand2 + '0'));
                        break;
                    case '/':
                        stack.push((char) (operand1 / operand2 + '0'));
                        break;
                }
            }
        }
        return Character.getNumericValue(stack.pop());
    }
}