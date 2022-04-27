package graph.components.vertex;

import graph.components.Component;
import services.DecoStrings;

public class Vertex extends Component {

    public Vertex(String label) {
        super(label);
    }

    @Override
    public String toPrintMatrix() {
        // TODO Auto-generated method stub
        return DecoStrings.BLUE(super.toPrintMatrix());
    }

    @Override
    public String toString() {
        return DecoStrings.BLUE(super.toString());
    }
}
