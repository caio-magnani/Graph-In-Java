import graph.Graph;
import graph.components.Edge;
import graph.components.Vertex;

public class App {
    public static void main(String[] args) throws Exception {

        Graph g = new Graph();
        Vertex<Integer> a = new Vertex<Integer>("a");
        Vertex<Integer> b = new Vertex<Integer>("b");
        Vertex<Integer> c = new Vertex<Integer>("c");
        Vertex<Integer> d = new Vertex<Integer>("d");
        Edge<Integer> aTOb = new Edge<Integer>("a - b", a.getId(), b.getId(), 0);
        g.addComponent(a);
        g.addComponent(b);
        g.addComponent(c);
        g.addComponent(d);
        g.addComponent(aTOb);
        System.out.println(g);
        g.removeComponent(c);
        System.out.println(g);
        System.out.println(g.getVertex(2));
    }
}
