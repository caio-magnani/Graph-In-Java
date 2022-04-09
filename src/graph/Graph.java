package graph;

import java.util.TreeMap;

import graph.components.Vertex;
import graph.components.egde.Egde;

public class Graph<T extends Object> {
    Matrix<Vertex<T>, Egde<T>> incidence;
    public Graph(){
        this.incidence = new Matrix<Vertex<T>, Egde<T>>();
    }
    public void addVertex(Vertex<T> v){
        this.incidence.addLine(v);
    }
    public Vertex<T> getVertex(String label){
        Vertex<T> aux = new Vertex<T>(label);
        return this.incidence.getLineByObject(aux);
    }
}
