import graph.Graph;
import graph.ValorableUndirectionalGraph;
import graph.components.vertex.Vertex;

public class App {
    public static void main(String[] args) {
        Graph g = new ValorableUndirectionalGraph();
        g.addVertex(new Vertex("Brasil", 1));
        g.addVertex(new Vertex("Belo Horizonte", 2));
        System.out.println(g);
        g.setVertex(new Vertex("Brasil", 1), new Vertex("Nova York", 1));
        System.out.println(g);
    }
}
