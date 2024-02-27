/**
 * Implementación de la interfaz StackInterface utilizando un ArrayList para almacenar elementos.
 */
import java.util.ArrayList;
public class ArrayListStack implements StackInterface {
    private ArrayList<String> stack;

    /**
     * Constructor por defecto que inicializa una nueva pila vacía.
     */
    public ArrayListStack() {
        stack = new ArrayList<>();
    }

    /**
     * Inserta un nuevo elemento en la parte superior de la pila.
     * @param str el elemento a ser insertado en la pila.
     * @throws NullPointerException si el elemento a insertar es nulo.
     */
    public void push(String str) {
        stack.add(str);
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     * @return el elemento eliminado de la parte superior de la pila.
     * @throws IndexOutOfBoundsException si la pila está vacía.
     */

    public String pop() {
        return stack.remove(stack.size() - 1);
    }

    /**
     * Devuelve el elemento en la parte superior de la pila sin eliminarlo.
     * @return el elemento en la parte superior de la pila.
     * @throws IndexOutOfBoundsException si la pila está vacía.
     */
    public String peek() {
        return stack.get(stack.size() - 1);
    }
    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
