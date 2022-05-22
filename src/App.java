import graph.map.Map;
import services.CsvReader;
import services.DecoStrings;

public class App {
    public static void main(String[] args) throws Exception {
        Map g = new Map(CsvReader.loadFile("br.csv"));
        System.out.println(DecoStrings.RED("Need to be 330 but is :" + g.getAllEdges().size()));
        System.out.println(g);
        System.out.println(g.matrixToString());
    }
}
