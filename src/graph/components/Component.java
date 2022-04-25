package graph.components;

public class Component {
    private static int lastId = -1;
    private int id;
    private String label;

    public Component(String label) {
        this.id = ++lastId;
        this.label = label;
    }

    public int getId() {
        return this.id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object obj) {
        Component compObj = (Component) obj;
        return this.id == compObj.id;
    }

    @Override
    public String toString() {
        return "" + this.getId();
    }
}