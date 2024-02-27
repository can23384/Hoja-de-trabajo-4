
import java.util.Stack;


/**
 * La interfaz StackInterface representa una pila (stack) en la cual se pueden almacenar caracteres.
 */
public interface StackInterface {
    
    /**
     * Inserta un nuevo elemento en la parte superior de la pila.
     * @param c el caracter a ser insertado en la pila.
     * @throws NullPointerException si el caracter es nulo.
     */
    void push(char c);
    
    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     * @return el caracter que se eliminó de la pila.
     * @throws EmptyStackException si la pila está vacía.
     */
    char pop();
    
    /**
     * Devuelve el elemento en la parte superior de la pila sin eliminarlo.
     * @return el caracter en la parte superior de la pila.
     * @throws EmptyStackException si la pila está vacía.
     */
    char peek();
    
    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario.
     */
    boolean isEmpty();
}