package graph.matrix;

public class Cell<T> {
    private T value;
    private int line;
    private int column;

    public Cell(T value, int line, int column) {
        this.value = value;
        this.line = line;
        this.column = column;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        Cell<T> objCell = null;

        try {
            objCell = (Cell<T>) obj;
        } catch (ClassCastException e) {
            return false;
        }
        return (this.getLine() == objCell.getLine() && this.getColumn() == objCell.getColumn());
    }

    @Override
    public String toString() {
        return "Cell in line " + this.getLine()
                + " and colunm " + this.getColumn()
                + " with a value " + this.getValue().toString();
    }
}
