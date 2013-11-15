package ds.graph;

import ds.List;
import ds.Set;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author Nabeel Ali Memon
 */
public class Graph<T> {
  Set<Vertex<T>> vertices;

  public Graph() {
    vertices = new Set<>();
  }

  int numVertices() {
    return vertices.size();
  }

  int numEdges() {
    return vertices
        .stream()
        .mapToInt(v -> v.adjacencyList.size())
        .sum();
  }

  void addEdge(T v1, T v2) {
    //v1 - v2
    Vertex<T> f;
    Optional<Vertex<T>> first = vertices
        .stream()
        .filter(v -> v.equals(v1))
        .findFirst();

    if (!first.isPresent()) {
      f = new Vertex<>(v1);
      this.vertices.add(f);
    } else {
      f = first.get();
    }
    f.adjacencyList.add(v2);

    //v2 - v1
    Vertex<T> s;
    Optional<Vertex<T>> second = vertices
        .stream()
        .filter(v -> v.equals(v2))
        .findFirst();

    if (!second.isPresent()) {
      s = new Vertex<>(v2);
      this.vertices.add(s);
    } else {
      s = second.get();
    }
    s.adjacencyList.add(v1);
  }

  List<T> adjacencyList(T element) {
    return vertices
        .stream()
        .filter(v -> v.element.equals(element))
        .findFirst()
        .orElseThrow(NoSuchElementException::new)
        .adjacencyList;
  }

  public static class Vertex<T> {
    T element;
    List<T> adjacencyList;

    public Vertex() {
      adjacencyList = new List<>();
    }

    public Vertex(T element) {
      this();
      this.element = element;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) { return true; }
      if (o == null || getClass() != o.getClass()) { return false; }

      Vertex vertex = (Vertex) o;

      if (element != null ? !element.equals(vertex.element) : vertex.element != null) { return false; }

      return true;
    }

    @Override
    public int hashCode() {
      return element != null ? element.hashCode() : 0;
    }
  }
}
