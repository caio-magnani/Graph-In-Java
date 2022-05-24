import graph.components.Edge;
import graph.components.Vertex;
import matrix.AdjacenceMatrix;
import matrix.Matrix;

public class AppForTesting {

    public static void main(String[] args) {
        AdjacenceMatrix<Vertex<Integer>, Edge<Integer>> m = new AdjacenceMatrix<>();
        Vertex<Integer> a = new Vertex<Integer>("a");
        Vertex<Integer> b = new Vertex<Integer>("b");
        Vertex<Integer> c = new Vertex<Integer>("c");
        Edge<Integer> aTOb = new Edge<Integer>("a To b", a.getId(), b.getId(), 0);
        Edge<Integer> aTOc = new Edge<Integer>("a To c", a.getId(), c.getId(), 0);
        m.addVertex(a);
        m.addVertex(b);
        m.addVertex(c);
        m.addEdge(aTOb);
        m.addEdge(aTOc);
        System.out.println(m);
        m.removeEdge(aTOb);
        System.out.println(m);
    }
}
