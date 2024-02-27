/**
 * La clase SinglyLinkedListStack representa una pila (stack) implementada utilizando una lista enlazada simple.
 * Esta clase hereda de la clase LinkedListStack y proporciona implementaciones para los métodos push() y pop().
 */


import java.util.EmptyStackException;

public class SinglyLinkedListStack extends LinkedListStack {

    /**
     * Inserta un nuevo elemento en la parte superior de la pila.
     * @param data el caracter a ser insertado en la pila.
     * @throws NullPointerException si el caracter es nulo.
     * @post El elemento dado se agrega en la parte superior de la pila.
     */
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

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     * @return el caracter que se eliminó de la pila.
     * @throws EmptyStackException si la pila está vacía.
     * @post El elemento en la parte superior de la pila se elimina.
     */
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