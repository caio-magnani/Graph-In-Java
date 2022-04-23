package graph.components.vertex;

import graph.components.Valorable;

public class ValorableVertex<T> extends Vertex implements Valorable<T> {
    private T value;

    public ValorableVertex(String label, int name, T value) {
        super(label, name);
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
