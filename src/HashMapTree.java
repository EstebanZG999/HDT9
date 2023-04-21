import java.util.HashMap;

/**
 * This class implements the Tree interface using a HashMap to store key-value pairs.
 * The keys must implement the Comparable interface to ensure they can be sorted in the HashMap.
 * @param <K> the type of the keys stored in the HashMap
 * @param <V> the type of the values stored in the HashMap
 */
public class HashMapTree<K extends Comparable<K>, V> implements Tree<K, V> {

    /**
     * The HashMap used to store the key-value pairs
     */
    private HashMap<K, V> hashMap;

    /**
     * Creates a new instance of the HashMapTree class with an empty HashMap
     */
    public HashMapTree() {
        hashMap = new HashMap<>();
    }

    /**
     * Inserts a new key-value pair into the HashMap
     * @param key the key to insert
     * @param value the value associated with the key
     */
    @Override
    public void insert(K key, V value) {
        hashMap.put(key, value);
    }

    /**
     * Searches for a value associated with the given key in the HashMap
     * @param key the key to search for
     * @return the value associated with the key, or null if the key is not in the HashMap
     */
    @Override
    public V search(K key) {
        return hashMap.get(key);
    }
}
