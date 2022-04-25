package graph.matrix;

import java.util.ArrayList;

public class Matrix<T> {
    private ArrayList<Cell<T>> cells;
    private int[][] positions;
    private int lines;
    private int columns;

    public Matrix() {
        this.cells = new ArrayList<Cell<T>>();
        this.lines = 1;
        this.columns = 1;
        this.positions = new int[lines][columns];
    }

    public int getLines() {
        return lines;
    }

    private void setLines(int lines) {
        this.lines = lines;
    }

    public int getColumns() {
        return columns;
    }

    private void setColunms(int columns) {
        this.columns = columns;
    }

    public void addCell(Cell<T> cell) {
        this.cells.add(cell);
        this.set(cell.getLine(), cell.getColumn(), this.cells.indexOf(cell));
    }

    public Cell<T> getCell(int line, int column) {
        return this.cells.get(this.positions[line][column]);
    }

    public Cell<T> setCell(Cell<T> newer) {
        return this.cells.set(this.positions[newer.getLine()][newer.getColumn()], newer);
    }

    @Override
    public String toString() {
        String s = new String();
        for (int l = 0; l < this.getLines(); l++) {
            for (int c = 0; c < this.getColumns(); c++) {
                if (this.positions[l][c] < 0)
                    s += "|" + "n";
                else
                    s += "|" + this.cells.get(this.positions[l][c]).getValue();
            }
            s += "|\n";
        }
        return s;
    }

    // positions manipulations
    private void set(int line, int column, int value) {
        try {
            this.positions[line][column] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            if (line > this.getLines() - 1)
                this.setLines(line + 1);
            if (column > this.getColumns() - 1)
                this.setColunms(column + 1);
            grow();
            this.positions[line][column] = value;
        }
    }

    private void grow() {
        int[][] aux = new int[this.getLines()][this.getColumns()];
        for (int l = 0; l < this.getLines(); l++) {
            for (int c = 0; c < this.getColumns(); c++) {
                try {
                    aux[l][c] = this.positions[l][c];
                } catch (IndexOutOfBoundsException e) {
                    aux[l][c] = -1;
                }
            }
        }
        this.positions = aux;
    }
}
