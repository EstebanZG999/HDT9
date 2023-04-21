import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AVLTreeTest {

    @Test
    public void testInsertAndSearch() {
        AVLTree<Integer, String> tree = new AVLTree<>();

        // Insert some keys and values
        tree.insert(4, "four");
        tree.insert(2, "two");
        tree.insert(6, "six");
        tree.insert(1, "one");
        tree.insert(3, "three");
        tree.insert(5, "five");
        tree.insert(7, "seven");

        // Test that the values are stored correctly
        assertEquals("one", tree.search(1));
        assertEquals("two", tree.search(2));
        assertEquals("three", tree.search(3));
        assertEquals("four", tree.search(4));
        assertEquals("five", tree.search(5));
        assertEquals("six", tree.search(6));
        assertEquals("seven", tree.search(7));

        // Test searching for a key that doesn't exist
        assertNull(tree.search(8));
    }
}
