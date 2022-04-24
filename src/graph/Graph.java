package graph;

import java.util.TreeMap;
import java.util.Map.Entry;

import graph.components.edge.Edge;
import graph.components.vertex.Vertex;
import graph.matrix.AdjacencyMatrix;
import services.DecoStrings;

public abstract class Graph<V extends Vertex, E extends Edge> {
    private AdjacencyMatrix matrix;
    private TreeMap<Integer, V> vertexs;
    private TreeMap<Integer, E> edges;
    protected int lastVertex;

    public Graph(TreeMap<Integer, V> vertexs,
            TreeMap<Integer, E> edges) {
        this.vertexs = vertexs;
        this.edges = edges;
        this.matrix = new AdjacencyMatrix();
        this.lastVertex = 1;
    }

    public void addVertex(V v) {
        this.vertexs.put(lastVertex, v);
    }

    public Vertex getVertex(String label) {
        for (Entry<Integer, V> entry : this.vertexs.entrySet()) {
            if (entry.getValue().getLabel().equals(label)) {
                return entry.getValue();
            }
        }
        return null;
    }

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
