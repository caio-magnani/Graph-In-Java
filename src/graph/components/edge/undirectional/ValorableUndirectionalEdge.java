package graph.components.edge.undirectional;

import graph.components.Valorable;

public class ValorableUndirectionalEdge<T extends Number> extends UndirectionalEdge implements Valorable<T> {
    private T value;

    public ValorableUndirectionalEdge(String label, int v1, int v2, T value) {
        super(label, v1, v2);
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }
}
