package graph.components;

public abstract class Egde<T extends Object> {
    private String label;
    private Vertex<T> v1;
    private Vertex<T> v2;

    public Egde(Vertex<T> v1, Vertex<T> v2){
        this.setV1(v1);
        this.setV2(v2);
        this.setLabel();
    }
    public Vertex<T> getV1(){
        return this.v1;
    }
    public void setV1(Vertex<T> v1){
        this.v1=v1;
    }
    public Vertex<T> getV2(){
        return this.v2;
    }
    public void setV2(Vertex<T> v2){
        this.v2=v2;
    }

    public String getLabel(){
        return this.label;
    }
    public void setLabel(){
        this.label=v1.getLabel()+"---"+v2.getLabel();
    }
}
