package graph.components.edge.undirectional;

import graph.components.edge.Edge;
import services.DecoStrings;

public class UndirectionalEdge extends Edge {

    public UndirectionalEdge(String label, int v1, int v2) {
        super(label, v1, v2);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean equals(Object obj) {
        UndirectionalEdge objEdge = (UndirectionalEdge) obj;
        return (this.getV1() == objEdge.getV1() && this.getV2() == objEdge.getV2())
                ||
                (this.getV1() == objEdge.getV2() && this.getV2() == objEdge.getV1());
    }

    @Override
    public String toString() {
        return super.toString() + " - " + DecoStrings.YELLOW(this.getLabel());
    }
}
