package graph.matrix;

import java.util.ArrayList;

public class Matrix {
    private double[][] matrix;
    private int c;
    private int l;
    /*
     * |00| 01 | 02 | 03 |
     * |01|0101|0102|0103|
     * |02|0201|0202|0203|
     * |03|0301|0302|0303|
     */

    public Matrix() {
        this.matrix = new double[1][1];
        this.l = 1;
        this.c = 1;
    }

    public int getL() {
        return l;
    }

    public int getC() {
        return c;
    }

    public double get(int l, int c) {
        return this.matrix[l][c];
    }

    public ArrayList<Double> getColumn(int c) {
        ArrayList<Double> column = new ArrayList<Double>();
        for (int l = 0; l < this.l; l++) {
            column.add(this.matrix[l][c]);
        }
        return column;
    }

    public void setColumn(int olderColumn, int[] newerColunm) {
        for (int l = 0; l < this.l; l++) {
            set(l, olderColumn, newerColunm[l]);
        }
    }

    public void removeColumn(int column) {
        double[][] aux = new double[this.l][this.c - 1];
        for (int l = 0; l < this.l; l++) {
            for (int c = 0; c < this.c; c++) {
                if (c < column) {
                    aux[l][c] = this.matrix[l][c];
                }
                if (c > column)
                    aux[l][c - 1] = this.matrix[l][c];
            }
        }
        this.matrix = aux;
        this.c -= 1;
    }

    public ArrayList<Double> getLine(int l) {
        ArrayList<Double> line = new ArrayList<Double>();
        for (int c = 0; c < this.c; c++) {
            line.add(this.matrix[l][c]);
        }
        return line;
    }

    public void setLine(int olderLine, int[] newerLine) {
        for (int c = 0; c < this.c; c++) {
            set(olderLine, c, newerLine[c]);
        }
    }

    public void removeLine(int line) {
        double[][] aux = new double[this.l - 1][this.c];
        for (int c = 0; c < this.c; c++) {
            for (int l = 0; l < this.l; l++) {
                if (l == line)
                    aux[l][c] = 0;
                else if (l < line) {
                    aux[l][c] = this.matrix[l][c];
                }
                if (l > line)
                    aux[l - 1][c] = this.matrix[l][c];
            }
        }
        this.matrix = aux;
        this.l -= 1;
    }

    // Matrix Manupulation

    public void set(int line, int column, double value) {
        try {
            this.matrix[line][column] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            if (line > this.l - 1)
                this.l = line + 1;
            if (column > this.c - 1)
                this.c = column + 1;
            grow();
            this.matrix[line][column] = value;
        }
    }

    private void grow() {
        double[][] aux = new double[this.l][this.c];
        for (int l = 0; l < this.l; l++) {
            for (int c = 0; c < this.c; c++) {
                try {
                    aux[l][c] = this.matrix[l][c];
                } catch (ArrayIndexOutOfBoundsException e) {
                    aux[l][c] = 0;
                }
            }
        }
        this.matrix = aux;
    }

    @Override
    public String toString() {
        String s = new String();
        for (int l = 0; l < this.l; l++) {
            for (int c = 0; c < this.c; c++) {
                s += "|" + this.matrix[l][c];
            }
            s += "|\n";
        }
        return s;
    }
}
