import java.util.Stack;
import java.util.Vector;

public class VectorStack implements StackInterface {
    private Stack<Character> stack;

    public VectorStack() {
        stack = new Stack<>();
    }

    @Override
    public void push(char c) {
        stack.push(c);
    }

    @Override
    public char pop() {
        return stack.pop();
    }

    @Override
    public char peek() {
        return stack.peek();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}