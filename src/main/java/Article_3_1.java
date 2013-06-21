import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
  
  public static abstract class AbstractST<Key extends Comparable<? super Key>, Value> 
      implements ST<Key, Value> {
    public AbstractST() {
    }

    @Override public abstract void put(Key key, Value val);

    @Override public abstract Value get(Key key);

    @Override public void delete(Key key) {
      throw new UnsupportedOperationException("Yet to be implemented");
    }

    @Override public boolean contains(Key key) {
      throw new UnsupportedOperationException("Yet to be implemented");
    }

    @Override public boolean isEmpty() {
      throw new UnsupportedOperationException("Yet to be implemented");
    }

    @Override public int size() {
      throw new UnsupportedOperationException("Yet to be implemented");
    }

    @Override public Key min() {
      throw new UnsupportedOperationException("Yet to be implemented");
    }

    @Override public Key max() {
      throw new UnsupportedOperationException("Yet to be implemented");
    }

    @Override public Key floor(Key key) {
      throw new UnsupportedOperationException("Yet to be implemented");
    }

    @Override public Key ceiling(Key key) {
      throw new UnsupportedOperationException("Yet to be implemented");
    }

    @Override public int rank(Key key) {
      throw new UnsupportedOperationException("Yet to be implemented");
    }

    @Override public Key select(int k) {
      throw new UnsupportedOperationException("Yet to be implemented");
    }

    @Override public void deleteMin() {
      throw new UnsupportedOperationException("Yet to be implemented");
    }

    @Override public void deleteMax() {
      throw new UnsupportedOperationException("Yet to be implemented");
    }

    @Override public int size(Key lo, Key hi) {
      throw new UnsupportedOperationException("Yet to be implemented");
    }

    @Override public Iterable<Key> keys(Key lo, Key hi) {
      throw new UnsupportedOperationException("Yet to be implemented");
    }

    @Override public Iterable<Key> keys() {
      throw new UnsupportedOperationException("Yet to be implemented");
    }
  } 
  
  public static class SequentialSearch<Key extends Comparable<? super Key>, Value> extends 
      AbstractST<Key, Value> implements ST<Key, Value> {
    
    class Node {
      Key key;
      Value value;
      Node next;
      
      Node(Key key, Value value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
      }

    }
    
    int size = 0;
    Node entryPointToInternalList;
    
    //search for the key and if found, update value. otherwise add key/value 
    @Override public void put(Key key, Value val) {
      Node internalList = entryPointToInternalList;
      for (;internalList != null; internalList = internalList.next) {
        //search hit
        if (key.equals(internalList.key)) {
          internalList.value = val;
          size++;
          return;
        }
      }
      //search miss. add new node at the head
      entryPointToInternalList = new Node(key, val, entryPointToInternalList);
      size++;
      return;
    }

    //search for the key and return associated value
    @Override public Value get(Key key) {
      Node internalList = entryPointToInternalList;
      for (;internalList != null; internalList = internalList.next) {
        if (key.equals(internalList.key)) {
          return internalList.value;
        }
      }
      return null;
    }

    @Override public int size() {
      return size;
    }

    @Override public Iterable<Key> keys() {
      return super.keys();
    }

    @Override public void delete(Key key) {
      Node internalList = entryPointToInternalList;
      //if the first node is to be deleted
      if (internalList != null && internalList.key.equals(key)) {
        entryPointToInternalList = internalList.next;
        size--;
        return;
      }
      //otherwise look for all next nodes to delete them before reaching them
      if (internalList.next != null && internalList.next.key.equals(key)) {
        internalList = internalList.next.next;
        size--;
        return;
      }
    }
  }

  public static class BinarySearchST<Key extends Comparable<? super Key>, Value>
      extends AbstractST<Key, Value> implements ST<Key, Value> {

    final Key[] keys;
    final Value[] values;
    int size;

    public BinarySearchST(int capacity) {
      this.keys = (Key[]) new Comparable[capacity];
      this.values = (Value[]) new Object[capacity];
      this.size = 0;
    }

    @Override public void put(Key key, Value val) {
      int rank = rank(key);
      if (key.equals(keys[rank])) {
        values[rank] = val;
        return;
      }
      //shift underlying arrays' entries
      for (int j = size; j >= rank + 1; j--) {
        keys[j] = keys[j-1];
        values[j] = values[j-1];
      }
      //put the new key and value
      keys[rank] = key;
      values[rank] = val;
      size++;
    }

    @Override public Value get(Key key) {
      int rank = rank(key);
      if (key.equals(keys[rank])) {
        return values[rank];
      }
      return null;
    }

    @Override public int size() {
      return size;
    }

    int rank(Key key, int lo, int hi) {
      if (lo > hi) return lo;
      int mid = lo + (hi - lo) / 2;
      Key found = keys[mid];
      int comparison = key.compareTo(found);
      if (comparison < 0) { return rank(key, lo, mid - 1); }
      else if (comparison > 0) { return rank(key, mid + 1, hi); }
      return mid;
    }

    //bisection search for key (recursive version)
    @Override public int rank(Key key) {
      return rank(key, 0, size - 1);
    }

    //bisection search for key (iterative version)
    /*@Override public int rank(Key key) {
      if (keys.length == 0) return 0;
      int lo = 0;
      int hi = size - 1;
      while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        Key found = keys[mid];
        int comparison = key.compareTo(found);
        if (comparison == 0) {return mid;}
        else if (comparison > 0) {lo = mid + 1;}
        else if (comparison < 0) {hi = mid - 1;}
      }
      return lo;
    }*/

    @Override public Key min() {
      return keys[0]; //since it's a sorted array
    }

    @Override public Key max() {
      return keys[size - 1]; //since it's a sorted array
    }

    @Override public Key select(int k) {
      if (k > size) { return null; }
      return keys[k];
    }

    @Override public Key ceiling(Key key) {
      int rank = rank(key);
      if (rank >= size) { return null; }
      return select(rank);
    }

    @Override public Key floor(Key key) {
      int below = rank(key) - 1;
      if (below <= size) { return null; }
      return select(below);
    }

    @Override public Iterable<Key> keys() {
      if (size > 0) {
        return keys(keys[0], keys[size - 1]);
      }
      else {
        return Collections.emptyList();
      }
    }

    @Override public boolean contains(Key key) {
      return select(rank(key)) != null;
    }

    @Override public void delete(Key key) {
      super.delete(key);
    }

    @Override public void deleteMin() {
      super.deleteMin();
    }

    @Override public void deleteMax() {
      super.deleteMax();
    }

    @Override public Iterable<Key> keys(Key lo, Key hi) {
      List<Key> boundedKeys = new ArrayList<>();
      int lowerBound = rank(lo);
      int upperBound = rank(hi);
//      for (keys[lowerBound - 1])
      return super.keys(lo, hi);
    }
  }
}