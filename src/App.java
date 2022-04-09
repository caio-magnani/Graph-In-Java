import graph.Graph;
import graph.Matrix;
import graph.components.Vertex;

public class App {
    public static void main(String[] args) throws Exception {
        Graph<String> g = new Graph<String>();
        g.addVertex(new Vertex<>(1));
        g.addVertex(new Vertex<>(2));
        g.addVertex(new Vertex<>(3));
        g.addVertex(new Vertex<>(4));
        g.addVertex(new Vertex<>(5));
        System.out.println(g.getVertex("V4").getLabel());
    }
}
