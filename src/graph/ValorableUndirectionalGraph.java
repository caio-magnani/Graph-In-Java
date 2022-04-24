package graph;

import java.util.TreeMap;
import java.util.Map.Entry;

import graph.components.edge.undirectional.ValorableUndirectionalEdge;
import graph.components.vertex.ValorableVertex;

public class ValorableUndirectionalGraph<V extends ValorableVertex, E extends ValorableUndirectionalEdge>
        extends Graph<V, E> {

    public ValorableUndirectionalGraph(
            TreeMap<Integer, V> vertexs,
            TreeMap<Integer, E> edges) {
        super(vertexs, edges);

    }

    @Override
    public boolean addEdge(E e) {
        if (super.edges.containsValue(e))
            return false;
        super.edges.put(lastEdge, e);
        super.matrix.set(e.getV1(), e.getV2(), e.getValue().intValue());
        super.matrix.set(e.getV2(), e.getV1(), e.getValue().intValue());
        return true;
    }

    @Override
    public E getEdge(String label) {
        for (Entry<Integer, E> entry : this.edges.entrySet()) {
            if (entry.getValue().getLabel().equals(label)) {
                return entry.getValue();
            }
        }
        return null;
    }

}
