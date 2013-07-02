import java.util.Iterator;
import java.util.Objects;

/**
 * @author Nabeel Ali Memon
 */
public final class Article_3_5 {
  public static class SeparateChainingHashST<K extends Comparable<? super K>, V>
    implements Iterable<K> {
    int N; //no. of key-value pairs
    int M; //size of table
    int modCount;
    Article_1_1.List<Entry<K, V>>[] entriesTable;

    public SeparateChainingHashST() {
      this(997);
    }

    public SeparateChainingHashST(int M) {
      modCount = 0;
      N = 0;
      this.M = M;
      entriesTable = (Article_1_1.List<Entry<K, V>>[]) new Article_1_1.List[997];
      for (int i = 0; i < M; i++) {
        entriesTable[i] = new Article_1_1.LinkedList<>();
      }
    }

    int hash(Object key) {
      Objects.requireNonNull(key);
      return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value) {
      Article_1_1.List<Entry<K, V>> entryIndex = entriesTable[hash(key)];
      entryIndex.add(new Entry<K, V>(key, value));
      modCount++;
      N++;
    }

    public V get(Object key) {
      int hash = hash(key);
      Article_1_1.List<Entry<K, V>> entries = entriesTable[hash];
      for (int i = 0; i < entries.size(); i++) {
        Entry<K, V> entry = entries.get(i);
        if (entry.getKey().equals(key)) {
          return entry.getValue();
        }
      }
      return null;
    }

    int size() {
      return N;
    }

    @Override public Iterator<K> iterator() {
      return null;
    }

    class Entry<K extends Comparable<? super K>, V> {
      K key;
      V value;

      Entry(K key, V value) {
        this.key = key;
        this.value = value;
      }

      K getKey() {
        return key;
      }

      void setKey(K key) {
        this.key = key;
      }

      V getValue() {
        return value;
      }

      void setValue(V value) {
        this.value = value;
      }
    }
  }
}