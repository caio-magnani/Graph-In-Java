package matrix;

import java.util.ArrayList;

import graph.components.Component;
import graph.components.Edge;
import graph.components.Vertex;
import services.DecoStrings;

public class AdjacenceMatrix<V extends Vertex<? extends Number>, E extends Edge<? extends Number>>
        extends Matrix<Component> {
    public AdjacenceMatrix() {
        super();
        this.addValue(new Component("\\"), 0, 0);
    }

    public Component getComponent(int id) {
        for (int l = 0; l < this.getLines(); l++) {
            for (int c = 0; c < this.getColumns(); c++) {
                Component component = this.getCell(l, c).getValue();
                if (component.getId() == id) {
                    return component;
                }
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<V> getAllVertexs() {
        ArrayList<V> vertexs = new ArrayList<V>();
        for (int c = 1; c < this.getColumns(); c++) {
            vertexs.add((V) this.getValue(0, c));
        }
        return vertexs;
    }

    public ArrayList<E> getAllEdgesOf(V vertex) {
        ArrayList<E> edges = new ArrayList<E>();
        for (int c = 0; c < this.getColumns(); c++) {
            edges.add(this.getValue());
        }
        return edges;
    }

    public void addVertex(V v) {
        addValue(v, v.getId(), 0);
        addValue(v, 0, v.getId());
    }

    public void removeVertex(V toRemove) {
        this.removeLine(toRemove.getId());
        this.removeCollumn(toRemove.getId());
    }

    public void addEdge(E e) {
        addValue(e, e.getV1(), e.getV2());
        addValue(e, e.getV2(), e.getV1());
    }

    public void removeEdge(E toRemove) {
        removeCell(new Cell<Component>(toRemove, toRemove.getV1(), toRemove.getV2()));
        removeCell(new Cell<Component>(toRemove, toRemove.getV2(), toRemove.getV1()));
    }

    @Override
    public String toString() {
        String s = DecoStrings.CYAN("Matrix:\n\n");
        for (int l = 0; l < this.getLines(); l++) {
            for (int c = 0; c < this.getColumns(); c++) {
                try {
                    s += DecoStrings.CYAN("|") + this.getCell(l, c).getValue().toMatrix();
                } catch (IndexOutOfBoundsException e) {
                    s += DecoStrings.CYAN("|") + DecoStrings.BLACK("n");
                }
            }
            s += DecoStrings.CYAN("|\n");
        }
        return s;
    }

}
