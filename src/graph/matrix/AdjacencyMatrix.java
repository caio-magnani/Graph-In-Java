package graph.matrix;

import java.util.ArrayList;

import graph.components.Component;
import services.DecoStrings;

public class AdjacencyMatrix<V extends Component, E extends Component> extends Matrix<Component> {

    public AdjacencyMatrix() {
        super();
    }

    @SuppressWarnings("unchecked")
    public ArrayList<V> getAllVertexs() {
        ArrayList<V> vertexs = new ArrayList<>();
        for (int c = 1; c < this.getColumns(); c++) {
            vertexs.add((V) this.getCell(0, c).getValue());
        }
        return vertexs;
    }

    public ArrayList<E> getAllEdges() {
        ArrayList<E> edges = new ArrayList<>();
        for (int l = 1; l < this.getLines(); l++) {
            for (int c = 1; c < this.getColumns(); c++) {
                try {
                    if (!edges.contains((E) this.getCell(l, c).getValue()))
                        edges.add((E) this.getCell(l, c).getValue());
                } catch (IndexOutOfBoundsException e) {
                    // ignore, do nothing
                }
            }
        }
        return edges;
    }

    @Override
    public String toString() {
        String s = DecoStrings.CYAN("Matrix:\n\n");
        for (int l = 0; l < this.getLines(); l++) {
            for (int c = 0; c < this.getColumns(); c++) {
                try {
                    s += DecoStrings.CYAN("|") + this.getCell(l, c).getValue();
                } catch (IndexOutOfBoundsException e) {
                    s += DecoStrings.CYAN("|") + "n";
                }
            }
            s += DecoStrings.CYAN("|\n");
        }
        return s;
    }
}
