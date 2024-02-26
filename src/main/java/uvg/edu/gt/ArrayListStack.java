import java.util.ArrayList;

public class ArrayListStack implements StackInterface {
    private ArrayList<Character> stack;

    public ArrayListStack() {
        stack = new ArrayList<>();
    }

    @Override
    public void push(char c) {
        stack.add(c);
    }

    @Override
    public char pop() {
        return stack.remove(stack.size() - 1);
    }

    @Override
    public char peek() {
        return stack.get(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}