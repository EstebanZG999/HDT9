/**
 * La clase AVLTree implementa una estructura de datos de árbol binario de búsqueda
 * autoequilibrado (AVL) con claves y valores asociados.
 *
 * @param <K> El tipo de claves almacenadas en el árbol, que deben implementar la interfaz Comparable.
 * @param <V> El tipo de valores asociados a las claves almacenadas en el árbol.
 */
public class AVLTree<K extends Comparable<K>, V> implements Tree<K, V> {

    private class Node {
        K key;
        V value;
        Node left, right;
        int height;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
            height = 1;
        }
    }

    private Node root;

    private int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    private int balanceFactor(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    /**
     * Crea un nuevo nodo con la clave y el valor especificados.
     *
     * @param x   La clave del nodo.
     */
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    /**
     * Inserta una nueva clave y su valor asociado en el árbol AVL.
     * Si la clave ya existe en el árbol, no se realiza ninguna acción.
     *
     * @param key   La clave a insertar en el árbol.
     * @param value El valor asociado a la clave.
     */
    @Override
    public void insert(K key, V value) {
        root = insertRecursively(root, key, value);
    }

    private Node insertRecursively(Node node, K key, V value) {
        if (node == null) return new Node(key, value);
        if (key.compareTo(node.key) < 0) {
            node.left = insertRecursively(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insertRecursively(node.right, key, value);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = balanceFactor(node);

        if (balance > 1) {
            if (key.compareTo(node.left.key) < 0) {
                return rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (balance < -1) {
            if (key.compareTo(node.right.key) > 0) {
                return leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    /**
     * Busca y devuelve el valor asociado a una clave en el árbol AVL.
     * Si la clave no se encuentra en el árbol, devuelve null.
     *
     * @param key La clave cuyo valor asociado se desea buscar.
     * @return El valor asociado a la clave si se encuentra, de lo contrario null.
     */
    @Override
    public V search(K key) {
        Node currentNode = root;
        while (currentNode != null) {
            if (key.compareTo(currentNode.key) < 0) {
                currentNode = currentNode.left;
            } else if (key.compareTo(currentNode.key) > 0) {
                currentNode = currentNode.right;
            } else {
                return currentNode.value;
            }
        }
        return null;
    }
}
