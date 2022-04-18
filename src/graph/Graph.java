package graph;

import java.util.TreeMap;

import graph.components.Vertex;
import graph.matrix.Adjacency;

public class Graph<T> {
    private Adjacency matrix;
    private TreeMap<Integer, Vertex<T>> vertexs;
    int lastVertex;

    public Graph() {
        this.lastVertex = 0;
        matrix = new Adjacency();
    }

    public void addVertex(Vertex<T> v) {
        this.vertexs.put(lastVertex, v);
        this.matrix.addVertex(lastVertex);
        lastVertex++;
    }

    public void setVertex(Vertex<T> older, Vertex<T> newer) {

    }
}
