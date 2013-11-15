package ds.graph;

import edu.princeton.cs.introcs.In;

import java.util.NoSuchElementException;

/**
 * @author Nabeel Ali Memon
 */
public class Graphs {
  public static Graph<Integer> build(Graph<Integer> g, In inStream) {
    inStream.readInt(); //dump it
    int edges = inStream.readInt();
    for (int i = 0; i < edges; i++) {
      g.addEdge(inStream.readInt(), inStream.readInt());
    }
    return g;
  }

  public static <T> int degree(Graph<T> g, T elem) {
    return g.vertices
            .stream()
            .filter(v -> v.element.equals(elem))
            .findFirst()
            .orElseThrow(NoSuchElementException::new)
            .adjacencyList
            .size();
  }

  public static <T> int maxDegree(Graph<T> g) {
    return g.vertices
        .parallelStream()
        .map(v -> degree(g, v.element))
        .max(Integer::compareTo)
        .orElse(0);
  }

  public static <T> int avgDegree(Graph<T> g) {
    return 2 * g.numEdges() / g.numVertices();
  }

  public static <T> int numSelfLoops(Graph<T> g) {
    return g.vertices
            .parallelStream()
            .mapToInt(v -> {
              for (T adj : v.adjacencyList) {
                if (v.element.equals(adj)) {
                  return 1;
                }
              }
              return 0;
            })
            .sum();
  }
}
