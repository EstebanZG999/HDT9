/**
 * La interfaz Tree define una estructura de datos de árbol binario de búsqueda
 * genérica con claves y valores asociados.
 * Las clases que implementan esta interfaz deben proporcionar métodos de inserción y búsqueda.
 *
 * @param <K> El tipo de claves almacenadas en el árbol, que deben implementar la interfaz Comparable.
 * @param <V> El tipo de valores asociados a las claves almacenadas en el árbol.
 */
public interface Tree<K extends Comparable<K>, V> {
    /**
     * Inserta una nueva clave y su valor asociado en el árbol.
     * Las clases que implementan esta interfaz deben especificar el comportamiento de la inserción.
     *
     * @param key   La clave a insertar en el árbol.
     * @param value El valor asociado a la clave.
     */
    void insert(K key, V value);
    /**
     * Busca y devuelve el valor asociado a una clave en el árbol.
     * Las clases que implementan esta interfaz deben especificar el comportamiento de la búsqueda.
     *
     * @param key La clave cuyo valor asociado se desea buscar.
     * @return El valor asociado a la clave si se encuentra, de lo contrario null.
     */
    V search(K key);
}