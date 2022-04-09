package graph.components.egde;

import graph.components.Vertex;
import graph.components.egde.exceptions.IsALoopException;

public class Directed<T extends Object> extends Egde<T>{
    private Vertex<T> origin;
    private Vertex<T> destiny;

    public Directed() {
        super();
    }

    public Directed(int label) {
        super.setLabel(label);
    }

    public Directed(Vertex<T> origin, Vertex<T> destiny,int label){
        super.setLabel(label);
        this.origin = origin;
        this.destiny = destiny;
    }

    @Override
    public Vertex<T> getV1(){
        return origin;
    }

    @Override
    public void setV1(Vertex<T> v1) throws IsALoopException{
        try {
            if(this.destiny.equals(v1))
                throw new IsALoopException();
            this.origin = v1;
        } catch (NullPointerException e) {
            this.origin = v1;
        }
    }

    @Override
    public Vertex<T> getV2() {
        return destiny;
    }

    @Override
    public void setV2(Vertex<T> v2) throws IsALoopException{
        try {
            if(this.origin.equals(v2))
                throw new IsALoopException();
            this.destiny = v2;
        } catch (NullPointerException e) {
            this.destiny = v2;
        }
    }

    @Override
    public String toString() {
        return super.getLabel()+"={ "+this.getV1().toString()+", "+this.getV2().toString()+"}";
    }

    @Override
    public int getValue(Vertex<T> vertex) {
        if(vertex.equals(origin))
            return -1;
        return 1;
    }
}
