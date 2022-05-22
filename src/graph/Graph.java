package graph;

import graph.components.Edge;
import graph.components.Vertex;
import matrix.AdjacenceMatrix;

public class Graph<V extends Vertex<? extends Number>, E extends Edge<? extends Number>> extends AdjacenceMatrix<V, E> {

    public Graph() {
        super();
    }

    @SuppressWarnings("unchecked")
    public E getEdge(int id) {
        try {
            return (E) this.getComponent(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public V getVertex(int id) {
        try {
            return (V) this.getComponent(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addComponent(V v) {
        this.addVertex(v);
    }

    public void addComponent(E e) {
        this.addEdge(e);
    }

    public void removeComponent(E e) {
        this.removeEdge(e);
    }

    public void removeComponent(V e) {
        this.removeVertex(e);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
