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

    public ArrayList<Cell<T>> getCells() {
        return cells;
    }

    public void addValue(T value, int line, int column) {
        Cell<T> newer = new Cell<T>(value, line, column);
        this.cells.add(newer);
        this.set(line, column, this.cells.indexOf(newer));
    }

    public T getValue(int line, int column) {
        return cells.get(this.positions[line][column]).getValue();
    }

    public void setValue(T value, int line, int column) {
        cells.set(this.positions[line][column], new Cell<T>(value, line, column));
    }

    protected int getLines() {
        return lines;
    }

    private void setLines(int lines) {
        this.lines = lines;
    }

    protected int getColumns() {
        return columns;
    }

    private void setColunms(int columns) {
        this.columns = columns;
    }

    protected void addCell(Cell<T> cell) {
        this.cells.add(cell);
        this.set(cell.getLine(), cell.getColumn(), this.cells.indexOf(cell));
    }

    protected Cell<T> getCell(int line, int column) {
        return this.cells.get(this.positions[line][column]);
    }

    protected Cell<T> getCell(T value) {
        for (Cell<T> cell : cells) {
            if (this.equals(value))
                return cell;
        }
        return null;
    }

    protected Cell<T> setCell(Cell<T> newer) {
        return this.cells.set(this.positions[newer.getLine()][newer.getColumn()], newer);
    }

    public void print() {
        for (Cell<T> c : this.cells) {
            System.out.println("line = "
                    + c.getLine()
                    + ", column = "
                    + c.getColumn()
                    + ", value = "
                    + c.getValue().toString());
        }
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
