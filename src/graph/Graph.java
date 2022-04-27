package graph;

import graph.components.Component;
import graph.components.edge.Edge;
import graph.components.vertex.Vertex;
import graph.matrix.AdjacencyMatrix;
import graph.matrix.Cell;
import services.DecoStrings;

public abstract class Graph<V extends Vertex, E extends Edge> {
    protected AdjacencyMatrix<V,E> matrix;
    private int lastVertex;

    public Graph() {
        super();
        this.lastVertex = 0;
        this.matrix = new AdjacencyMatrix<V, E>();
        this.matrix.addValue(new Component("\\"), 0, 0);
    }

    protected int getLastVertex() {
        return ++this.lastVertex;
    }

    protected Cell<Component> getCell(int componentId) {
        for (Cell<Component> cell : this.matrix.getCells()) {
            if (cell.getValue().getId() == componentId)
                return cell;
        }
        return null;
    }

    public int getPositionOf(int vertexId) {
        Cell<Component> vertex = this.getCell(vertexId);
        return vertex.getLine() + vertex.getColumn();
    }

    @Override
    public String toString() {
        String s = new String();
        s += DecoStrings.YELLOW("----------------------------------------\n");
        s += DecoStrings.BLUE("Vertexs:\n");
        for (Vertex v : this.matrix.getAllVertexs()) {
            s += v.infos() + "\n";
        }
        s += DecoStrings.YELLOW("----------------------------------------\n");
        s += DecoStrings.GREEN("Edges:\n");
        for (Edge e : this.matrix.getAllEdges()) {
            s += e.infos() + "\n";
        }
        s += DecoStrings.YELLOW("----------------------------------------\n");
        return s + this.matrix.toString();
    }
}
