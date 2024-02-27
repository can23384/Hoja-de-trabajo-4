/*
 * La clase DoublyLinkedListStack representa una pila (stack) implementada utilizando una lista enlazada doblemente enlazada.
 * Esta clase extiende LinkedListStack y proporciona operaciones para agregar y eliminar elementos en la pila.
 */


import java.util.EmptyStackException;

public class DoublyLinkedListStack extends LinkedListStack {
    /**
     * Clase interna que representa un nodo en la lista enlazada doblemente enlazada.
     * Extiende la clase Node de LinkedListStack.
     */
    protected static class Node extends LinkedListStack.Node {
        Node prev; // El nodo previo en la lista.

        /**
         * Constructor para crear un nuevo nodo con el dato especificado.
         * @param data el dato que se almacenará en el nodo.
         */
        Node(char data) {
            super(data);
        }
    }

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
            ((Node) head).prev = newNode;
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
        if (head != null) {
            ((Node) head).prev = null;
        }
        return data;
    }
}