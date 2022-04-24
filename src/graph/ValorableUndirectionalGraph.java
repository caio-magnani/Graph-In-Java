package graph;

import java.util.TreeMap;

import graph.components.edge.undirectional.ValorableUndirectionalEdge;
import graph.components.vertex.ValorableVertex;

public class ValorableUndirectionalGraph<T> extends Graph<ValorableVertex<T>, ValorableUndirectionalEdge<T>> {

    public ValorableUndirectionalGraph() {
        super(new TreeMap<Integer, ValorableVertex<T>>(), new TreeMap<Integer, ValorableUndirectionalEdge<T>>());
    }
}
