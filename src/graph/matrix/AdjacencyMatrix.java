package graph.matrix;

import java.util.ArrayList;

import services.DecoStrings;

public class AdjacencyMatrix extends Matrix {

    public AdjacencyMatrix() {
        super();
    }

    @Override
    public ArrayList<Double> getLine(int l) {
        ArrayList<Double> line = super.getLine(l);
        line.remove(0);
        return line;
    }

    @Override
    public ArrayList<Double> getColumn(int c) {
        ArrayList<Double> column = super.getColumn(c);
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
