package graph.components.egde;

import graph.components.Vertex;
import graph.components.egde.exceptions.IsALoopException;

public class Undirected<T extends Object> extends Egde<T>{

    private Vertex<T> v1;
    private Vertex<T> v2;

    public Undirected() {
        super();
    }

    public Undirected(int label) {
        super.setLabel(label);
    }

    public Undirected(Vertex<T> v1, Vertex<T> v2,int label){
        super.setLabel(label);
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public Vertex<T> getV1(){
        return v1;
    }

    @Override
    public void setV1(Vertex<T> v1) throws IsALoopException{
        try {
            if(this.v2.equals(v1))
                throw new IsALoopException();
            this.v1 = v1;
        } catch (NullPointerException e) {
            this.v1 = v1;
        }
    }

    @Override
    public Vertex<T> getV2() {
        return v2;
    }

    @Override
    public void setV2(Vertex<T> v2) throws IsALoopException{
        try {
            if(this.v1.equals(v2))
                throw new IsALoopException();
            this.v2 = v2;
        } catch (NullPointerException e) {
            this.v2 = v2;
        }
        
    }

    @Override
    public String toString() {
        return super.getLabel()+"={ "+this.getV1().toString()+", "+this.getV2().toString()+"}";
    }

    @Override
    public int getValue(Vertex<T> vertex) {
        return 1;
    }
}
