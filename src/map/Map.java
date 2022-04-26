package map;

import java.util.Map.Entry;
import java.util.ArrayList;

import graph.ValorableUndirectionalGraph;
import graph.components.edge.undirectional.ValorableUndirectionalEdge;
import graph.components.vertex.ValorableVertex;

public class Map extends ValorableUndirectionalGraph<City, RoadWay> {

    public Map() {
        super();
    }

    public Map(ArrayList<String> strings) {
        super();
        for (String strs : strings) {
            String[] s = strs.split(",");
            City city = new City(
                    s[0],
                    Double.parseDouble(s[1]),
                    Double.parseDouble(s[2]),
                    Integer.parseInt(s[8]));

            addVertex(new ValorableVertex<City>(city.getName(), city));
        }
        generateEdges();
    }

    public void addCity(City c) {
        this.addVertex(new ValorableVertex<City>(c.getName(), c));
    }

    public void addRoad(RoadWay r, City a, City b) {
        int v1Id = this.getVertex(a.getName()).getId();
        int v2Id = this.getVertex(b.getName()).getId();
        this.addEdge(new ValorableUndirectionalEdge<RoadWay>(r.getName(), v1Id, v2Id, r));
    }

    private void generateEdges() {
        for (Entry<Integer, ValorableVertex<City>> e : this.vertexs.entrySet()) {
            generateEdgesOf(e.getValue());
        }
    }

    private void generateEdgesOf(ValorableVertex<City> v) {
        for (Entry<Integer, ValorableVertex<City>> e : this.vertexs.entrySet()) {
            RoadWay road = new RoadWay(v.getValue(), e.getValue().getValue());
            ValorableUndirectionalEdge<RoadWay> edge = new ValorableUndirectionalEdge<>(
                    road.getName(),
                    this.getCell(e.getValue()).getLine(),
                    this.getCell(v).getColumn(), road);
            if (!this.edges.containsValue(edge))
                this.addEdge(edge);
        }
    }
}
