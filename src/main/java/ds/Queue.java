package ds;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author Nabeel Ali Memon
 */
public class Queue<T> implements Container<T> {
  int head;
  int tail;
  int size;
  int modcount;
  T[] backingArray;

  public Queue() {
    this(10);
  }

  public Queue(int expectedSize) {
    backingArray = (T[])new Object[expectedSize];
  }

  void ensureCapacity() {
    if (head == backingArray.length - 1) {
      int diff = head - tail;
      T[] temp;
      if (diff == backingArray.length - 1) {
        temp = (T[])new Object[backingArray.length << 1]; 
      } else {
        temp = (T[])new Object[backingArray.length];
      }
      System.arraycopy(backingArray, tail, temp, 0, diff);
      backingArray = temp;
      tail = 0;
      head = diff;
    }
  }
  
  public void enqueue(T element) {
    ensureCapacity();
    modcount++;
    size++;
    backingArray[head++] = element;
  }
  
  public T dequeue() {
    if (tail <= head) {
      modcount++;
      size--;
      return backingArray[tail++];
    } else {
      throw new IndexOutOfBoundsException("Nothing to dequeue");
    }
  }
  
  @Override public int size() {
    return size;
  }

  @Override public boolean contains(T element) {
    return this.parallelStream().filter(e -> e.equals(element)).findFirst().isPresent();
  }

  @Override public Iterator<T> iterator() {
    return new Iterator<T>() {
      int snapshot = modcount;
      int idx = tail;
      
      @Override public boolean hasNext() {
        return idx < head;
      }

      @Override public T next() {
        if (snapshot != modcount) {
          throw new ConcurrentModificationException("Queue was mutated during iteration");
        }
        return backingArray[idx++];
      }
    };
  }
}
