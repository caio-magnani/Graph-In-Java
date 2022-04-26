package graph;

import java.util.ArrayList;

import graph.components.Component;
import graph.components.edge.Edge;
import graph.components.vertex.Vertex;
import graph.matrix.Matrix;
import services.DecoStrings;

public class AdjacencyMatrix extends Matrix<Component> {

    public AdjacencyMatrix() {
        super();
    }

    public ArrayList<Vertex> getAllVertexs() {
        ArrayList<Vertex> vertexs = new ArrayList<>();
        for (int c = 1; c < this.getColumns(); c++) {
            vertexs.add((Vertex) this.getCell(0, c).getValue());
        }
        return vertexs;
    }

    public ArrayList<Edge> getAllEdges() {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int l = 1; l < this.getLines(); l++) {
            for (int c = 1; c < this.getColumns(); c++) {
                try {
                    if (!edges.contains((Edge) this.getCell(l, c).getValue()))
                        edges.add((Edge) this.getCell(l, c).getValue());
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
