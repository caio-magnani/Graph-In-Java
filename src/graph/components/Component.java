package graph.components;

public abstract class Component {
    private String label;
    private int name;

    public Component(String label, int name) {
        this.label = label;
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
