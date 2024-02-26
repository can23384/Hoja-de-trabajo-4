public abstract class LinkedListStack implements StackInterface {
    protected Node head;

    protected static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    @Override
    public abstract void push(char data);

    @Override
    public abstract char pop();

    @Override
    public char peek() {
        if (isEmpty()) {
            throw new RuntimeException("El stack está vacío");
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}