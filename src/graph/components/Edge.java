package graph.components;

import services.DecoStrings;

public class Edge<V extends Number> extends Component {
    private V value;
    private int v1;
    private int v2;

    public Edge(String label, int v1, int v2, V value) {
        super(label);
        this.v1 = v1;
        this.v2 = v2;
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getV1() {
        return v1;
    }

    public void setV1(int v1) {
        this.v1 = v1;
    }

    public int getV2() {
        return v2;
    }

    public void setV2(int v2) {
        this.v2 = v2;
    }

    @Override
    public String toMatrix() {
        return DecoStrings.GREEN(super.toMatrix());
    }
}