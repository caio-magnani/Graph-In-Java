package graph;

import java.util.TreeMap;

import graph.components.edge.undirectional.ValorableUndirectionalEdge;
import graph.components.vertex.ValorableVertex;

public class ValorableUndirectionalGraph extends Graph {
    public ValorableUndirectionalGraph() {
        super(new TreeMap<Integer, ValorableVertex>(), new TreeMap<Integer, ValorableUndirectionalEdge>());
    }
}
