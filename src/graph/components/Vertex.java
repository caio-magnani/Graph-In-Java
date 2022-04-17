package graph.components;

public class Vertex<T> {

    private String label;
    private T object;

    public Vertex(){
        this.object = null;
        this.label = "Sem nome e Sem Objeto";
    }

    public Vertex(T object){
        this.object = object;
        this.label = "Sem Nome";
    }
    
    public Vertex(String label){
        this.object = null;
        this.setLabel(label);
    }

    public Vertex(T object, String label){
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
            Vertex<T> objVertex= (Vertex<T>) obj;
            return this.label.equals(objVertex.getLabel());
        } catch (Exception e) {
            return false;
        }
    }
    
}
