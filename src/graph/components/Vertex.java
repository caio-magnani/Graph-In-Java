package graph.components;

import services.DecoStrings;

public class Vertex<V extends Number> extends Component {

    private V value;

    public Vertex(String label) {
        super(label);
    }

    public Vertex(String label, V value) {
        super(label);
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toMatrix() {
        return DecoStrings.BLUE(super.toMatrix());
    }

    @Override
    public String toString() {
        return DecoStrings.BLUE(super.toString())
                + " - " + DecoStrings.BLUE(this.getLabel())
                + ", " + DecoStrings.PURPLE(this.getValue().toString());
    }
}
