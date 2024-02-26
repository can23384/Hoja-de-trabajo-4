public class DoublyLinkedListStack extends LinkedListStack {
    protected static class Node extends LinkedListStack.Node {
        Node prev;

        Node(char data) {
            super(data);
        }
    }

    @Override
    public void push(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            ((Node) head).prev = newNode;
            head = newNode;
        }
    }

    @Override
    public char pop() {
        if (isEmpty()) {
            throw new RuntimeException("El stack está vacío");
        }
        char data = head.data;
        head = head.next;
        if (head != null) {
            ((Node) head).prev = null;
        }
        return data;
    }
}