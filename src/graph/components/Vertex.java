package graph.components;

public class Vertex<T> {

    private String label;
    private T object;

    public Vertex(String label){
        this.object = null;
        this.label=label;
    }
    
    public Vertex(int label){
        this.object = null;
        this.setLabel(label);
    }

    public Vertex(T object, int label){
        this.object = object;
        this.setLabel(label);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label ="V"+ label;
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
            Vertex<T> objVertex= (Vertex<T>) obj;
            return this.label.equals(objVertex.getLabel());
        } catch (Exception e) {
            return false;
        }
    }
    
}
