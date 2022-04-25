package graph;

import java.util.Map.Entry;

import graph.components.Component;
import graph.components.edge.undirectional.ValorableUndirectionalEdge;
import graph.components.vertex.ValorableVertex;
import graph.matrix.Cell;
import services.DecoStrings;

public class ValorableUndirectionalGraph<V, E>
        extends Graph<ValorableVertex<V>, ValorableUndirectionalEdge<E>> {

    public ValorableUndirectionalGraph() {
        super();
    }

    public void addVertex(ValorableVertex<V> v) {
        int position = this.getLastVertex();
        this.addVertexInTreeMap(v);
        this.addCell(new Cell<Component>(v, position, 0));
        this.addCell(new Cell<Component>(v, 0, position));
    }

    public ValorableVertex<V> getVertex(String label) {
        for (Entry<Integer, ValorableVertex<V>> e : this.vertexs.entrySet()) {
            if (e.getValue().getLabel().equals(label)) {
                return e.getValue();
            }
        }
        return null;
    }

    public ValorableVertex<V> getVertex(int line, int column) {
        return this.vertexs.get(getCell(line, column).getValue().getId());
    }

    public void addEdge(ValorableUndirectionalEdge<E> e) {
        this.addEdgeInTreeMap(e);
        this.addCell(new Cell<Component>((Component) e, e.getV1(), e.getV2()));
        this.addCell(new Cell<Component>((Component) e, e.getV2(), e.getV1()));
    }

    @Override
    public String toString() {
        String s = DecoStrings.BLUE("Vertexs:\n");
        for (Entry<Integer, ValorableVertex<V>> v : this.vertexs.entrySet()) {
            s += DecoStrings.BLUE("" + v.getKey()) + " - "
                    + DecoStrings.BLUE(v.getValue().getLabel()) + " : "
                    + v.getValue().getValue() + "\n";
        }
        s += DecoStrings.GREEN("\nEdges:\n");
        for (Entry<Integer, ValorableUndirectionalEdge<E>> e : this.edges.entrySet()) {
            s += DecoStrings.GREEN("" + e.getKey()) + " - "
                    + DecoStrings.GREEN(e.getValue().getLabel()) + " : "
                    + e.getValue().getValue() + "\n";
        }
        return s + "\n" + super.toString();
    }
}
