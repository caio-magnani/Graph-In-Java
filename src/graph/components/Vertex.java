package graph.components;

import java.util.ArrayList;

public class Vertex<T> {

    private ArrayList<Egde<T>> edges;
    private String label;
    private T object;

    public Vertex() {
        this.edges = new ArrayList<Egde<T>>();
        this.object = null;
        this.label = "Sem nome e Sem Objeto";
    }

    public Vertex(T object) {
        this.edges = new ArrayList<Egde<T>>();
        this.object = object;
        this.label = "Sem Nome";
    }

    public ArrayList<Egde<T>> getEdges() {
        return edges;
    }

    public void addEgde(Egde<T> e) {
        this.edges.add(e);
    }

    public void removeEgde(Egde<T> e) {
        this.edges.remove(e);
    }

    public Vertex(String label) {
        this.object = null;
        this.setLabel(label);
    }

    public Vertex(T object, String label) {
        this.object = object;
        this.setLabel(label);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        try {
            Vertex<T> objVertex = (Vertex<T>) obj;
            return this.label.equals(objVertex.getLabel());
        } catch (Exception e) {
            return false;
        }
    }

}
