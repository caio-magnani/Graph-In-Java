package graph;

import java.util.TreeMap;
import java.util.Map.Entry;

import graph.components.edge.Edge;
import graph.components.vertex.Vertex;
import graph.matrix.AdjacencyMatrix;
import services.DecoStrings;

public abstract class Graph<V extends Vertex, E extends Edge> {
    protected AdjacencyMatrix matrix;
    protected TreeMap<Integer, V> vertexs;
    protected TreeMap<Integer, E> edges;
    protected static int lastVertex;
    protected static int lastEdge;

    public Graph(TreeMap<Integer, V> vertexs,
            TreeMap<Integer, E> edges) {
        this.vertexs = vertexs;
        this.edges = edges;
        matrix = new AdjacencyMatrix();
        lastVertex = 1;
        lastEdge = 1;
    }

    public boolean addVertex(V v) {
        if (this.vertexs.containsValue(v)) {
            return false;
        }
        this.vertexs.put(lastVertex, v);
        matrix.set(0, lastVertex, lastVertex);
        matrix.set(lastVertex, 0, lastVertex);
        lastVertex++;
        return true;
    }

    public V getVertex(String label) {
        for (Entry<Integer, V> entry : this.vertexs.entrySet()) {
            if (entry.getValue().getLabel().equals(label)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public int getPositionVertex(Vertex v) {
        for (Entry<Integer, V> entry : this.vertexs.entrySet()) {
            if (entry.getValue().equals(v)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public abstract boolean addEdge(E e);

    public abstract E getEdge(String label);

    @Override
    public String toString() {
        String str = new String();
        for (Entry<Integer, V> v : this.vertexs.entrySet()) {
            str += "|" + v.getValue().getLabel()
                    + " = " + DecoStrings.GREEN("" + v.getKey());
            str += "|\n";
        }
        return str + matrix.toString();
    }
}
