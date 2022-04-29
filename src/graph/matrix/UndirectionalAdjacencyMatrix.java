package graph.matrix;

import java.util.ArrayList;

import graph.components.edge.undirectional.UndirectionalEdge;
import graph.components.vertex.Vertex;

public class UndirectionalAdjacencyMatrix<V extends Vertex, E extends UndirectionalEdge> extends AdjacencyMatrix<V, E> {
    public UndirectionalAdjacencyMatrix() {
        super();
    }

    @Override
    public ArrayList<E> getAllEdges() {
        ArrayList<E> edges = new ArrayList<>();
        for (int l = 1; l < this.getLines(); l++) {
            for (int c = 1; c <= l; c++) {
                try {
                    edges.add((E) this.getCell(l, c).getValue());
                } catch (IndexOutOfBoundsException e) {
                    // ignore, do nothing
                }
            }
        }
        return edges;
    }
}
