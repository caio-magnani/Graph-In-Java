package graph;

import java.util.TreeMap;

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
        v.setName(lastVertex);
        lastVertex++;
        this.vertexs.put(v.getName(), v);
        this.matrix.addVertex(v.getName());
    }

    public void setVertex(Vertex older, Vertex newer) {
        this.vertexs.replace(older.getName(), older, newer);
    }

    public void removeVertex(Vertex older, Vertex newer) {
        this.vertexs.replace(older.getName(), older, newer);
    }

    @Override
    public String toString() {
        String str = new String();
        for (Vertex v : vertexs.values()) {
            str += "|" + v.getLabel()
                    + " = " + DecoStrings.GREEN("" + v.getName());
            str += "|\n";
        }
        return str + matrix.toString();
    }
}
