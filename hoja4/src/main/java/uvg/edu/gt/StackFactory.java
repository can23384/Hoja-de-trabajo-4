/**
 * La clase StackFactory es una fábrica para crear instancias de diferentes tipos de pilas (stacks).
 */

public class StackFactory {

    /**
     * Crea y devuelve una instancia de un tipo específico de pila.
     * @param type el tipo de pila que se desea crear. Debe ser "arraylist" o "vector".
     * @return una instancia de la pila especificada.
     * @throws IllegalArgumentException si se proporciona un tipo de pila no válido.
     */
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
}