package ds;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Optional;

/**
 * @author Nabeel Ali Memon
 */
public class List<T> implements Container<T> {
  T[] backingArray;
  int size;
  int modcount;

  public List() {
    this(10);
  }
  
  public List(int expectedSize) {
    backingArray = (T[])new Object[expectedSize];
  }

  public void add(T element) {
    ensureCapacity();
    backingArray[size++] = element;
    modcount++;
  }

  /*@Override public Optional<T> remove(T element) {
    Optional<T> elem = this.stream().filter(e -> e.equals(element)).findFirst();
    elem.ifPresent(e -> backingArray[1]);
    return elem;
  }*/
  
  /*public void remove(int idx) {
    if (idx > size - 1) {
      throw new IndexOutOfBoundsException();
    }
    
  }*/

  @Override public int size() {
    return size;
  }

  @Override public boolean contains(T element) {
    return this.parallelStream().filter(e -> e.equals(element)).findFirst().isPresent();
  }

  void ensureCapacity() {
    if (size == backingArray.length) {
      //do table doubling
      T[] temp = (T[])new Object[size << 1];
      System.arraycopy(backingArray, 0, temp, 0, backingArray.length);
      backingArray = temp;
    }
  }
  
  @Override public Iterator<T> iterator() {
    return new Iterator<T>() {
      int idx = 0;
      int snapshot = modcount;
      
      @Override public boolean hasNext() {
        return idx < size;
      }

      @Override public T next() {
        if (snapshot != modcount) {
          throw new ConcurrentModificationException("list was mutated during iteration");
        }
        return backingArray[idx++];
      }
    };
  }
}
