package graph;

import graph.components.Component;
import graph.components.edge.undirectional.ValorableUndirectionalEdge;
import graph.components.vertex.ValorableVertex;
import graph.matrix.UndirectionalAdjacencyMatrix;

public class ValorableUndirectionalGraph<V extends ValorableVertex, E extends ValorableUndirectionalEdge>
        extends Graph<V, E, UndirectionalAdjacencyMatrix<V, E>> {

    public ValorableUndirectionalGraph() {
        super();
        this.matrix = new UndirectionalAdjacencyMatrix<V, E>();
        this.matrix.addValue(new Component("\\"), 0, 0);
    }

    public void addComponent(V v) {
        int position = getLastVertex();
        this.matrix.addValue(v, 0, position);
        this.matrix.addValue(v, position, 0);
    }

    public V getVertex(int id) {
        return this.matrix.getVertex(id);
    }

    public void addComponent(E e) {
        int vertexPosition1 = this.getPositionOf(e.getV1());
        int vertexPosition2 = this.getPositionOf(e.getV2());
        this.matrix.addValue(e, vertexPosition1, vertexPosition2);
        this.matrix.addValue(e, vertexPosition2, vertexPosition1);
    }
}
