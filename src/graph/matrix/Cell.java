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

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        Cell<T> objCell = (Cell<T>) obj;
        return (this.line == objCell.getLine() && this.column == objCell.getColumn());
    }

    @Override
    public String toString() {
        return "Cell in line " + this.getLine()
                + " and colunm " + this.getColumn()
                + " with a value " + this.getValue().toString();
    }
}
