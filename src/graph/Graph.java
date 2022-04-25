package graph;

import java.util.TreeMap;

import graph.components.Component;
import graph.components.edge.Edge;
import graph.components.vertex.Vertex;
import graph.matrix.Cell;

public abstract class Graph<V extends Vertex, E extends Edge> extends AdjacencyMatrix<V, E> {

    protected TreeMap<Integer, V> vertexs;
    protected TreeMap<Integer, E> edges;
    private int lastVertex;

    public Graph() {
        super();
        this.lastVertex = 0;
        this.vertexs = new TreeMap<Integer, V>();
        this.edges = new TreeMap<Integer, E>();
        this.addCell(new Cell<Component>(new Component(""), 0, 0));
    }

    public int getLastVertex() {
        return ++this.lastVertex;
    }

    protected void addVertexInTreeMap(V v) {
        this.vertexs.put(v.getId(), v);
    }

    protected void removeVertexInTreeMap(V v) {
        this.vertexs.remove((Object) v);
    }

    protected void setVertexInTreeMap(V older, V newer) {
        this.removeVertexInTreeMap(older);
        this.addVertexInTreeMap(newer);
    }

    protected V getVertexInTreeMap(int id) {
        return this.vertexs.get(id);
    }

    protected void addEdgeInTreeMap(E e) {
        this.edges.put(e.getId(), e);
    }

    protected void removeEdgeInTreeMap(E e) {
        this.edges.remove((Object) e);
    }

    protected void setEdgeInTreeMap(E older, E newer) {
        this.removeEdgeInTreeMap(newer);
        this.addEdgeInTreeMap(newer);
    }

    protected E getEdgeInTreeMap(int id) {
        return this.edges.get(id);
    }
}
