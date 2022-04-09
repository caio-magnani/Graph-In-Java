package graph.components.egde;

import graph.components.Vertex;

public class Loop<T extends Object> extends Egde<T>{
    String label;
    Vertex<T> vertex;

    public Loop() {
        super();
    }

    public Loop(int label) {
        super.setLabel(label);
    }

    public Loop(Vertex<T> vertex,int label){
        super.setLabel(label);
        this.vertex=vertex;
    }

    @Override
    public Vertex<T> getV1() {
        return vertex;
    }

    @Override
    public void setV1(Vertex<T> v1) {
        this.vertex=v1;
    }

    @Override
    public Vertex<T> getV2() {
        return this.vertex;
    }

    @Override
    public void setV2(Vertex<T> v2) {
        this.vertex = v2;
    }

    @Override
    public int getValue(Vertex<T> vertex) {
        return 2;
    }

    @Override
    public String toString() {
        return super.getLabel()+"={ "+this.getV1().toString()+", "+this.getV2().toString()+"}";
    }
}
