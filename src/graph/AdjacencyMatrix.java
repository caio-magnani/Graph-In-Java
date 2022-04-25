package graph;

import graph.components.Component;
import graph.components.edge.Edge;
import graph.components.vertex.Vertex;
import graph.matrix.Matrix;
import services.DecoStrings;

public abstract class AdjacencyMatrix<V extends Vertex, E extends Edge> extends Matrix<Component> {

    public AdjacencyMatrix() {
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
