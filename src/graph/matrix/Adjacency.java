package graph.matrix;

import java.util.ArrayList;

import graph.services.DecoStrings;

public class Adjacency extends Matrix {
    public Adjacency() {
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

    // Pega O Grau do Vertice Positivo
    public int getDegreePositiveOfVertex(int v) {
        int degree = 0;
        ArrayList<Integer> line = this.getLine(v);
        for (int i : line) {
            degree += i;
        }
        return degree;
    }

    // Pega O Grau do Vertice Negativo
    public int getDegreeNegativeOfVertex(int v) {
        int degree = 0;
        ArrayList<Integer> column = this.getColumn(v);
        for (int i : column) {
            degree += i;
        }
        return degree;
    }

    // Pega O Grau do Vertice Não Direcionado
    public int getDegreeOfVertexUndirectional(int v) {
        return this.getDegreePositiveOfVertex(v);
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
        for (int i = 1; i <= this.getC(); i++) {
            if (this.get(v, i) >= 1) {
                neighbors.add(i);
            }
        }
        if (neighbors.isEmpty()) {
            neighbors.add(null);
        }

        return neighbors;
    }

    public void addEgdeUndirectional(int v1, int v2) {
        this.set(v1, v2, 1);
        this.set(v2, v1, 1);
    }

    public void removeEgdeUndirectional(int v1, int v2) {
        this.set(v1, v2, 0);
        this.set(v2, v1, 0);

    }

    public void addEgdeDirectional(int origin, int destiny) {
        this.set(origin, destiny, 1);
    }

    public void removeEgdeDirectional(int origin, int destiny) {
        this.set(origin, destiny, 0);
    }

    public void addLoop(int v) {
        this.set(v, v, 2);
    }

    public void removeLoop(int v) {
        this.set(v, v, 0);
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
