package graph.components.vertex;

import graph.components.Valorable;
import services.DecoStrings;

public class ValorableVertex<T> extends Vertex implements Valorable<T> {
    private T value;

    public ValorableVertex(String label, T value) {
        super(label);
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + DecoStrings.PURPLE("value = " + this.getValue());
    }
}
