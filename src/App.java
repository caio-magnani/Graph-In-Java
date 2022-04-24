import java.math.BigInteger;

import graph.ValorableUndirectionalGraph;
import graph.components.vertex.ValorableVertex;

public class App {
    public static void main(String[] args) {
        ValorableUndirectionalGraph<BigInteger> graph = new ValorableUndirectionalGraph<BigInteger>();
        graph.addVertex(new ValorableVertex(new String("Vertex 1"), new BigInteger("10000")));
        graph.addVertex(new ValorableVertex(new String("Vertex 2"), new BigInteger("20000")));
        System.out.println(graph);
        System.out.println(graph.getVertex("Vertex 1"));
        System.out.println(graph.getVertex("Vertex 2"));
    }
}
