package ds;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author Nabeel Ali Memon
 */
public class Stack<T> implements Container<T> {
  int size;
  int modcount;
  T[] backingArray;

  public Stack() {
    this(10);
  }

  public Stack(int expectedSize) {
    backingArray = (T[]) new Object[expectedSize];
  }

  public void push(T element) {
    ensureCapacity();
    backingArray[size++] = element;
    modcount++;
  }

  void ensureCapacity() {
    if (size == backingArray.length) {
      T[] temp = (T[]) new Object[size << 1];
      System.arraycopy(backingArray, 0, temp, 0, backingArray.length);
      backingArray = temp;
    }
  }

  public T pop() {
    if (size == 0) {
      throw new IndexOutOfBoundsException("Nothing more to pop");
    }
    modcount++;
    return backingArray[--size];
  }

  @Override public int size() {
    return size;
  }

  @Override public boolean contains(T element) {
    return this.parallelStream().filter(e -> e.equals(element)).findFirst().isPresent();
  }

  @Override public Iterator<T> iterator() {
    return new Iterator<T>() {
      int idx = size;
      int snapshot = modcount; 
      
      @Override public boolean hasNext() {
        return idx > 0;
      }

      @Override public T next() {
        if (snapshot != modcount) {
          throw new ConcurrentModificationException("stack was mutated during iteration");
        }
        return backingArray[--idx];
      }
    };
  }
}
