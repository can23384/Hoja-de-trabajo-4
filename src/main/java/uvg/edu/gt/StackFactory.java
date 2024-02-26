public class StackFactory {
    public static StackInterface createStack(String type) {
        switch (type.toLowerCase()) {
            case "arraylist":
                return new ArrayListStack();
            case "vector":
                return new VectorStack();
            default:
                throw new IllegalArgumentException("Tipo de stack no válido");
        }
    }
    public static void main(String[] args) {
        StackInterface stack = StackFactory.createStack("arraylist");
        stack.push('a');
        stack.push('b');
        stack.push('c');
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}