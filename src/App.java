import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import graph.components.edge.undirectional.UndirectionalEdge;
import graph.components.vertex.Vertex;
import graph.matrix.AdjacencyMatrix;
import map.Map;
import services.CsvReader;

public class App {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        AdjacencyMatrix<Vertex, UndirectionalEdge> a = new AdjacencyMatrix<>();
        Vertex v1 = new Vertex("a");
        a.addValue(v1, 0, 1);
        a.addValue(v1, 1, 0);
        Vertex v2 = new Vertex("b");
        a.addValue(v2, 0, 2);
        a.addValue(v2, 2, 0);
        Vertex v3 = new Vertex("c");
        a.addValue(v3, 0, 3);
        a.addValue(v3, 3, 0);
        Vertex v4 = new Vertex("d");
        a.addValue(v4, 0, 4);
        a.addValue(v4, 4, 0);
        UndirectionalEdge e1 = new UndirectionalEdge("V1 to V2", v1.getId(), v2.getId());
        UndirectionalEdge e2 = new UndirectionalEdge("V2 to V3", v2.getId(), v3.getId());
        UndirectionalEdge e3 = new UndirectionalEdge("V3 to V4", v3.getId(), v4.getId());
        UndirectionalEdge e4 = new UndirectionalEdge("V4 to V1", v4.getId(), v1.getId());
        a.addValue(e1, e1.getV1(), e1.getV2());
        a.addValue(e2, e2.getV1(), e1.getV2());
        a.addValue(e3, e3.getV1(), e1.getV2());
        a.addValue(e4, e4.getV1(), e1.getV2());
        System.out.println(a.getAllEdges());
        System.out.println(a);
        // Map m = new Map(CsvReader.loadFile());
        // System.out.println(m);
    }
}
