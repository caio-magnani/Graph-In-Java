package graph.components.edge.undirectional;

import graph.components.edge.Edge;

public class UndirectionalEdge extends Edge {

    public UndirectionalEdge(String label, int v1, int v2) {
        super(label, v1, v2);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean equals(Object obj) {
        UndirectionalEdge objEdge = (UndirectionalEdge) obj;
        return this.getLabel().equals(objEdge.getLabel());
    }
}
