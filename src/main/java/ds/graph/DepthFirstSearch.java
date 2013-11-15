package ds.graph;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author Nabeel Ali Memon
 */
public class DepthFirstSearch<T> {
  Map<Graph.Vertex<T>, Boolean> marked = new WeakHashMap<>();
  int count;

  public DepthFirstSearch(Graph<T> graph, Graph.Vertex<T> vertex) {
    for (Graph.Vertex<T> vert : graph.vertices) {
      marked.put(vert, false);
    }
    dfs(graph, vertex);
  }

  void dfs(Graph<T> graph, Graph.Vertex<T> vertex) {
    marked.put(vertex, true);
    count++;
    for (T adjacent : vertex.adjacencyList) {
      Graph.Vertex<T> adjacentVert = new Graph.Vertex<>(adjacent);
      if (!marked.get(adjacentVert)) {
        dfs(graph, adjacentVert);
      }
    }
  }

  public boolean isMarked(Graph.Vertex<T> vertex) {
    return marked.get(vertex);
  }

  public int count() {
    return count;
  }
}
