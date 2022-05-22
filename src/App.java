import graph.map.Map;
import services.CsvReader;
import services.DecoStrings;

public class App {
    public static void main(String[] args) throws Exception {
        Map g = new Map(CsvReader.loadFile("br.csv"));
        System.out.println(DecoStrings.RED("Need to be 330 but is :" + g.getAllEdges().size()));
        g.printVertexs();
        g.printEdges();
        g.removeComponent(g.getEdge(2, 10));
        System.out.println("Apos remover São Paulo <---> Belem");
        g.printEdges();

    }
}
