package matrix;

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

    protected void addValue(T value, int line, int column) {
        Cell<T> newer = new Cell<T>(value, line, column);
        this.cells.add(newer);
        this.set(line, column, this.cells.indexOf(newer));
    }

    protected T getValue(int line, int column) {
        return cells.get(this.positions[line][column]).getValue();
    }

    protected void setValue(T value, int line, int column) {
        cells.set(this.positions[line][column], new Cell<T>(value, line, column));
    }

    @SuppressWarnings("null")
    protected void removeValue(T value) {
        Cell<T> toRemove = this.getCell(value);
        this.removeCell(toRemove);
    }

    protected int getLines() {
        return lines;
    }

    private void setLines(int lines) {
        this.lines = lines;
    }

    protected void removeLine(int line) {
        for (int c = 0; c < this.getColumns(); c++) {
            for (int l = line; l < this.getLines() - 1; l++) {
                this.positions[l][c] = this.positions[l + 1][c];
            }
        }
        this.lines--;
        this.updateMatrix();
    }

    protected int getColumns() {
        return columns;
    }

    private void setColunms(int columns) {
        this.columns = columns;
    }

    protected void removeCollumn(int column) {
        for (int l = 0; l < this.getLines(); l++) {
            for (int c = column; c < this.getColumns() - 1; c++) {
                this.positions[l][c] = this.positions[l][c + 1];
            }
        }
        this.columns--;
        this.updateMatrix();
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

    @SuppressWarnings("null")
    protected void removeCell(Cell<T> toRemove) {
        this.cells.remove(toRemove);
        this.positions[toRemove.getLine()][toRemove.getColumn()] = -1;
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
            updateMatrix();
            this.positions[line][column] = value;
        }
    }

    private void updateMatrix() {
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
