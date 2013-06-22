import java.util.ArrayList;
import java.util.List;

/**
 * @author Nabeel Ali Memon
 */
public final class Article_4_1 {
  public final static class Graphs {
    public static int degree(Graph G, int v) {
      int degree = 0;
      for (int w : G.adj(v)) {
        degree++;
      }
      return degree;
    }

    public static int maxDegree(Graph G) {
      int thisDegree = 0;
      int maxDegree = 0;
      for (int thisVertex = 0; thisVertex < G.V(); thisVertex++) {
        thisDegree = degree(G, thisVertex); //we assume that degrees being from 0
        if (thisDegree > maxDegree) {
          maxDegree = thisDegree;
        }
      }
      return maxDegree;
    }

    public static int avgDegree(Graph G) {
      return 2 * (G.V() / G.E());
    }

    public static int numberOfSelfLoops(Graph G) {
      int selfLoops = 0;
      for (int thisVertex = 0; thisVertex < G.V(); thisVertex++) {
        for (Integer adjacentVertex : G.adj(thisVertex)) {
          if (thisVertex == adjacentVertex) {
            selfLoops++;
          }
        }
      }
      return selfLoops / 2; //each edge has been counted twice
    }
  }

  public static interface Graph {
    int V(); //no. of vertices
    int E(); //no. of edges
    void addEdge(int v, int w); //add edge between vertices v & w
    Iterable<Integer> adj(int v);
  }

  public static class Graph1 implements Graph {
    final int V;
    int E;
    List<Integer>[] adj;

    public Graph1(int V) {
      this.V = V;
      E = 0;
      adj = (List<Integer>[]) new ArrayList[V];
      for (int v = 0; v < V; v++) {
        adj[v] = new ArrayList<>();
      }
    }

    public Graph1(In in) {
      this(in.readInt()); //V
//      E = in.readInt();
      for (int i = 0; i < V; i++) {
        int v = in.readInt();
        int w = in.readInt();
        addEdge(v, w);
      }
    }

    @Override public int V() {
      return V;
    }

    @Override public int E() {
      return E;
    }

    @Override public void addEdge(int v, int w) {
      adj[v].add(w);
      adj[w].add(v);
      E++;
    }

    @Override public Iterable<Integer> adj(int v) {
      return adj[v];
    }
  }
}
