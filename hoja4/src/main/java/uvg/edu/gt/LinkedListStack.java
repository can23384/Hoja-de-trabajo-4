
/**
 * La clase LinkedListStack representa una pila (stack) implementada utilizando una lista enlazada.
 * Esta clase proporciona operaciones para agregar, eliminar y acceder a elementos en la pila.
 */
public abstract class LinkedListStack implements StackInterface {
    /**
     * El nodo en la parte superior de la pila.
     */
    protected Node head;

    /**
     * Clase interna que representa un nodo en la lista enlazada.
     */
    protected static class Node {
        char data; // El dato almacenado en el nodo.
        Node next; // El siguiente nodo en la lista.

        /**
         * Constructor para crear un nuevo nodo con el dato especificado.
         * @param data el dato que se almacenará en el nodo.
         */
        Node(char data) {
            this.data = data;
        }
    }

    /**
     * Inserta un nuevo elemento en la parte superior de la pila.
     * @param data el caracter a ser insertado en la pila.
     * @throws NullPointerException si el caracter es nulo.
     * @post El elemento dado se agrega en la parte superior de la pila.
     */
    @Override
    public abstract void push(char data);

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     * @return el caracter que se eliminó de la pila.
     * @throws EmptyStackException si la pila está vacía.
     * @post El elemento en la parte superior de la pila se elimina.
     */
    @Override
    public abstract char pop();

    /**
     * Devuelve el elemento en la parte superior de la pila sin eliminarlo.
     * @return el caracter en la parte superior de la pila.
     * @throws EmptyStackException si la pila está vacía.
     * @post El estado de la pila permanece sin cambios.
     */
    @Override
    public char peek() {
        if (isEmpty()) {
            throw new RuntimeException("El stack está vacío");
        }
        return head.data;
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario.
     * @post El estado de la pila permanece sin cambios.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }
}