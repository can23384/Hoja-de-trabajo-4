public class SinglyLinkedListStack extends LinkedListStack {
    @Override
    public void push(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
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
        return data;
    }
}