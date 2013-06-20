/**
 * @author Nabeel Ali Memon
 */
public class Article_3_1 {
  public interface ST<Key extends Comparable<? super Key>, Value> {
    //put key-value pair in table. remove key from table if value is null
    void put(Key key, Value val);
    //value paired with key. null if key is absent
    Value get(Key key);
    //remove key (and it's value) from the table
    void delete(Key key);
    //is there a value paired with key?
    boolean contains(Key key);
    //is the table empty?
    boolean isEmpty();
    //number of key-value pairs
    int size();
    //smallest key
    Key min();
    //largest key
    Key max();
    //smallest key less than or equal to key
    Key floor(Key key);
    //smallest key greater than or equal to key
    Key ceiling(Key key);
    //number of keys less than key
    int rank(Key key);
    //key of rank k
    Key select(int k);
    //delete smallest key
    void deleteMin();
    //delete largest key
    void deleteMax();
    //number of keys in [lo..hi]
    int size(Key lo, Key hi);
    //keys in [lo..hi] in sorted order
    Iterable<Key> keys(Key lo, Key hi);
    //all keys in table, in sorted order
    Iterable<Key> keys();
  }
}
