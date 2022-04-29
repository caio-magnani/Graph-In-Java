package graph.matrix;

import java.util.ArrayList;
import java.util.function.Predicate;

import graph.components.Component;
import graph.components.edge.Edge;
import graph.components.vertex.Vertex;
import services.DecoStrings;

public class AdjacencyMatrix<V extends Vertex, E extends Edge> extends Matrix<Component> {

    public AdjacencyMatrix() {
        super();
    }

    public V getVertex(int id) {
        for (V v : this.getAllVertexs()) {
            if (v.getId() == id)
                return v;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<V> getAllVertexs() {
        ArrayList<V> vertexs = new ArrayList<>();
        for (int c = 1; c < this.getColumns(); c++) {
            vertexs.add((V) this.getCell(0, c).getValue());
        }
        return vertexs;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<E> getAllEdges() {
        ArrayList<E> edges = new ArrayList<>();
        for (int l = 1; l < this.getLines(); l++) {
            for (int c = 1; c < this.getColumns(); c++) {
                try {
                    edges.add((E) this.getCell(l, c).getValue());
                } catch (IndexOutOfBoundsException e) {
                    // ignore, do nothing
                }
            }
        }
        return edges;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<E> getAllEdgesOf(V v) {
        ArrayList<E> edges = new ArrayList<>();
        int position = this.getPositionOfVertex(v);
        for (int c = 1; c < this.getColumns(); c++) {
            try{
                edges.add((E) this.getCell(position, c).getValue());
            }catch(IndexOutOfBoundsException e){
                // ignore
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
                    s += DecoStrings.CYAN("|") + this.getCell(l, c).getValue().toPrintMatrix();
                } catch (IndexOutOfBoundsException e) {
                    s += DecoStrings.CYAN("|") + DecoStrings.BLACK("n");
                }
            }
            s += DecoStrings.CYAN("|\n");
        }
        return s;
    }
}
