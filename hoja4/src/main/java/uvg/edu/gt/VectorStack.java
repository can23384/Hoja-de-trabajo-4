
import java.util.Stack;

/**
 * La clase VectorStack implementa la interfaz StackInterface utilizando un Stack respaldado por un Vector.
 */
public class VectorStack implements StackInterface {
    private Stack<Character> stack;

    /**
     * Crea una nueva instancia de VectorStack.
     * Se inicializa una nueva pila (stack) vacía.
     */
    public VectorStack() {
        stack = new Stack<>();
    }

    /**
     * Inserta un nuevo elemento en la parte superior de la pila.
     * @param c el caracter a ser insertado en la pila.
     * @throws NullPointerException si el caracter es nulo.
     */
    @Override
    public void push(char c) {
        stack.push(c);
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     * @return el caracter que se eliminó de la pila.
     * @throws EmptyStackException si la pila está vacía.
     */
    @Override
    public char pop() {
        return stack.pop();
    }

    /**
     * Devuelve el elemento en la parte superior de la pila sin eliminarlo.
     * @return el caracter en la parte superior de la pila.
     * @throws EmptyStackException si la pila está vacía.
     */
    @Override
    public char peek() {
        return stack.peek();
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}