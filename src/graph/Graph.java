package graph;

import java.util.TreeMap;
import java.util.Map.Entry;

import graph.components.edge.Edge;
import graph.components.vertex.Vertex;
import graph.matrix.AdjacencyMatrix;
import services.DecoStrings;

public abstract class Graph {
    private AdjacencyMatrix matrix;
    private TreeMap<Integer, Vertex> vertexs;
    private TreeMap<Integer, Edge> edges;
    protected int lastVertex;

    public Graph(TreeMap vertexs, TreeMap edges) {
        this.edges = edges;
        this.vertexs = vertexs;
        this.matrix = new AdjacencyMatrix();
        this.lastVertex = 1;
    }

    public void addVertex(Vertex v) {
        this.vertexs.put(lastVertex, v);
        this.matrix.set(0, lastVertex, lastVertex);
        lastVertex++;
    }

    public Vertex getVertex(String label) {
        for (Entry<Integer, Vertex> v : this.vertexs.entrySet()) {
            if (v.getValue().getLabel().equals(label))
                return v.getValue();
        }
        return null;
    }

    @Override
    public String toString() {
        String str = new String();
        for (Entry<Integer, Vertex> v : this.vertexs.entrySet()) {
            str += "|" + v.getValue().getLabel()
                    + " = " + DecoStrings.GREEN("" + v.getKey());
            str += "|\n";
        }
        return str + matrix.toString();
    }
}
