/**
 * This class provides a factory method for creating instances of classes that implement the Tree interface.
 */
public class TreeFactory {

    /**
     * Creates a new instance of a class that implements the Tree interface based on the treeType parameter.
     *
     * @param treeType a string indicating the type of tree to create ("avl", "redblack", or "map")
     * @param <K> the type of the keys stored in the tree
     * @param <V> the type of the values stored in the tree
     * @return a new instance of a class that implements the Tree interface
     * @throws IllegalArgumentException if the treeType parameter is null or not recognized
     */
    public static <K extends Comparable<K>, V> Tree<K, V> createTree(String treeType) {
        if (treeType == null) {
            throw new IllegalArgumentException("Tree type must not be null");
        }

        return switch (treeType.toLowerCase()) {
            case "avl" -> new AVLTree<>();
            case "redblack" -> new RedBlackTree<>();
            case "map" -> new HashMapTree<>();
            default -> throw new IllegalArgumentException("Invalid tree type");
        };
    }
}


