package graph.matrix;

import java.util.ArrayList;

import services.DecoStrings;

public class AdjacencyMatrix extends Matrix {
    int[] labels;

    public AdjacencyMatrix() {
        super();
    }

    public void addVertex(int v) {
        set(v, 0, v);
        set(0, v, v);
    }

    public void removeVertex(int v) {
        this.removeLine(v);
        this.removeColumn(v);
    }

    @Override
    public ArrayList<Integer> getLine(int l) {
        ArrayList<Integer> line = super.getLine(l);
        line.remove(0);
        return line;
    }

    @Override
    public ArrayList<Integer> getColumn(int c) {
        ArrayList<Integer> column = super.getColumn(c);
        column.remove(0);
        return column;
    }

    public ArrayList<Integer> getNeighbors(int v) {
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        for (int i = 1; i < this.getC(); i++) {
            if (this.get(v, i) >= 1) {
                neighbors.add(i);
            }
        }
        if (neighbors.isEmpty()) {
            neighbors.add(null);
        }

        return neighbors;
    }

    public void addUndirectionalEgde(int v1, int v2, int value) {
        this.set(v1, v2, value);
        this.set(v2, v1, value);
    }

    public void removeUndirectionalEgde(int v1, int v2) {
        this.set(v1, v2, 0);
        this.set(v2, v1, 0);

    }

    public void addDirectionalEgde(int origin, int destiny, int value) {
        this.set(origin, destiny, value);
    }

    public void removeDirectionalEgde(int origin, int destiny) {
        this.set(origin, destiny, 0);
    }

    @Override
    public String toString() {
        String s = new String();
        for (int l = 0; l < this.getL(); l++) {
            for (int c = 0; c < this.getC(); c++) {
                s += "|";
                if (c == 0 && l != 0 || c != 0 && l == 0)
                    s += DecoStrings.GREEN("" + this.get(l, c));
                else if (c == 0 && l == 0)
                    s += DecoStrings.GREEN("\\");
                else if (c == l && this.get(l, c) != 0)
                    s += DecoStrings.CYAN("" + this.get(l, c));
                else if (this.get(l, c) == 0)
                    s += DecoStrings.BLACK("0");
                else
                    s += DecoStrings.BLUE("" + this.get(l, c));
            }
            s += "|\n";
        }
        return s;
    }

}
