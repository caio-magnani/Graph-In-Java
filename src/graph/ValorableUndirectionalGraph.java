package graph;

import graph.components.edge.undirectional.ValorableUndirectionalEdge;
import graph.components.vertex.ValorableVertex;

public class ValorableUndirectionalGraph<V, E> extends Graph {

    public ValorableUndirectionalGraph() {
        super();
    }

    public void addComponent(ValorableVertex<V> v) {
        int position = getLastVertex();
        this.matrix.addValue(v, 0, position);
        this.matrix.addValue(v, position, 0);
    }

    public void addComponent(ValorableUndirectionalEdge<E> e) {
        int vertexPosition1 = this.getPositionOf(e.getV1());
        int vertexPosition2 = this.getPositionOf(e.getV2());
        this.matrix.addValue(e, vertexPosition1, vertexPosition2);
        this.matrix.addValue(e, vertexPosition2, vertexPosition1);
    }
}
