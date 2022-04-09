package graph.components.egde;

import graph.components.Vertex;
import graph.components.egde.exceptions.IsALoopException;
import graph.components.egde.exceptions.NotALoopException;

public abstract class Egde<T extends Object> {
    private String label;
    public Egde(){
        this.label="";
    }
    public abstract Vertex<T> getV1();
    public abstract void setV1(Vertex<T> v1) throws IsALoopException,NotALoopException;
    public abstract Vertex<T> getV2();
    public abstract void setV2(Vertex<T> v2) throws IsALoopException,NotALoopException;
    public abstract int getValue(Vertex<T> vertex);
    public String getLabel(){
        return this.label;
    }
    public void setLabel(int label){
        this.label="E"+label;
    }
}
