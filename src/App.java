import graph.ValorableUndirectionalGraph;
import graph.components.edge.undirectional.ValorableUndirectionalEdge;
import graph.components.vertex.ValorableVertex;

public class App {
    public static void main(String[] args) {
        ValorableUndirectionalGraph<Integer, Integer> graph = new ValorableUndirectionalGraph<>();
        ValorableVertex<Integer> a = new ValorableVertex<>("a", 1);
        ValorableVertex<Integer> b = new ValorableVertex<>("b", 2);
        ValorableVertex<Integer> c = new ValorableVertex<>("c", 3);
        graph.addComponent(a);
        graph.addComponent(b);
        graph.addComponent(c);
        graph.addComponent(new ValorableUndirectionalEdge<Integer>("a <---> b", a.getId(), b.getId(), 1));
        System.out.println(graph);
        // Map m = new Map(CsvReader.loadFile());
        // System.out.println(m);
    }
}
