package graph.components.vertex;

import graph.components.Component;

public class Vertex extends Component {

    public Vertex(String label) {
        super(label);
    }

    @Override
    public boolean equals(Object obj) {
        Vertex objVertex = (Vertex) obj;
        return this.getLabel().equals(objVertex.getLabel());
    }

}
