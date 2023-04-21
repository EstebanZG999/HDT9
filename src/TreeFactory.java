public class TreeFactory {

    public static <K extends Comparable<K>, V> Tree<K, V> createTree(String treeType) {
        if (treeType == null) {
            throw new IllegalArgumentException("Tree type must not be null");
        }

        switch (treeType.toUpperCase()) {
            case "AVL_TREE":
                return new AVLTree<>();
            case "RED_BLACK_TREE":
                return new RedBlackTree<>();
            default:
                throw new IllegalArgumentException("Invalid tree type");
        }
    }
}

