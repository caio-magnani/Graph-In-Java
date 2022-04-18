import graph.matrix.Adjacency;

public class App {
    public static void main(String[] args) {
        Adjacency m = new Adjacency();
        m.addVertex(1);
        m.addVertex(2);
        m.addVertex(3);
        m.addVertex(4);
        m.addVertex(5);
        m.addVertex(6);
        m.addEgdeUndirectional(1, 2);
        m.addEgdeDirectional(4, 5);
        m.addLoop(1);
        System.out.println("\nMatriz de Adjacencia:\n");
        System.out.println(m);
        System.out.println("Grau + do Vertice " + 1 + " = " + m.getDegreePositiveOfVertex(1));
        System.out.println("Grau + do Vertice " + 4 + " = " + m.getDegreePositiveOfVertex(4));
        System.out.println("Grau + do Vertice " + 5 + " = " + m.getDegreePositiveOfVertex(5));
        System.out.println("Grau - do Vertice " + 5 + " = " + m.getDegreeNegativeOfVertex(5));
    }
}
