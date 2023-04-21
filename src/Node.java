/**
 * La clase Node representa un nodo genérico en una estructura de árbol.
 * Esta clase utiliza un tipo genérico T para permitir el almacenamiento
 * de diferentes tipos de datos en el árbol.
 *
 * @param <T> El tipo de datos que se almacenará en los nodos del árbol.
 */
public class Node<T> {
    /**
     * El valor del nodo actual.
     */
    T value;

    /**
     * Referencia al nodo hijo izquierdo.
     */
    Node<T> left;

    /**
     * Referencia al nodo hijo derecho.
     */
    Node<T> right;

    /**
     * Crea un nuevo nodo con el valor especificado.
     * Inicialmente, las referencias a los nodos hijos izquierdo y derecho
     * son nulas, lo que significa que este nodo es una hoja en el árbol.
     *
     * @param value El valor que se almacenará en el nodo.
     */
    public Node(T value) {
        this.value = value;
    }
}

