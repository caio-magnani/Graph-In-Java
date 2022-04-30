package graph.components.edge;

import graph.components.Component;
import services.DecoStrings;

public abstract class Edge extends Component {
    private int v1;
    private int v2;

    public Edge(String label, int v1, int v2) {
        super(label);
        this.v1 = v1;
        this.v2 = v2;
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
    public String toPrintMatrix() {
        // TODO Auto-generated method stub
        return DecoStrings.GREEN(super.toPrintMatrix());
    }

    @Override
    public String toString() {
        return DecoStrings.GREEN(super.toString());
    }
}
