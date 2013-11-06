package ds;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author Nabeel Ali Memon
 */
public interface Container<T> extends Iterable<T> {
  int size();
  boolean contains(T element);
  
  default Stream<T> stream() {
    return StreamSupport.stream(spliterator(), false);
  }

  default Stream<T> parallelStream() {
    return StreamSupport.stream(spliterator(), true);
  }
}
