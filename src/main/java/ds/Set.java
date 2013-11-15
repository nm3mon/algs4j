package ds;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Nabeel Ali Memon
 */
public class Set<T> implements Container<T> {
  HashSet<T> internalSet;

  public Set() {
    internalSet = new HashSet<>();
  }

  public boolean add(T element) {
    return internalSet.add(element);
  }

  @Override public int size() {
    return internalSet.size();
  }

  @Override public boolean contains(T element) {
    return internalSet.contains(element);
  }

  @Override public Iterator<T> iterator() {
    return internalSet.iterator();
  }
}
