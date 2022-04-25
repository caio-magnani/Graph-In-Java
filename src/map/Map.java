package map;

import java.util.Map.Entry;
import java.util.ArrayList;

import graph.ValorableUndirectionalGraph;
import graph.components.edge.undirectional.ValorableUndirectionalEdge;
import graph.components.vertex.ValorableVertex;

public class Map extends ValorableUndirectionalGraph<City, RoadWay> {

    public Map(ArrayList<String> strings) {
        for (String strs : strings) {
            String[] s = strs.split(",");
            City city = new City(
                    s[0],
                    Double.parseDouble(s[1]),
                    Double.parseDouble(s[2]),
                    Integer.parseInt(s[8]));

            addVertex(new ValorableVertex<City>(city.getName(), city));
            generateEdges();
        }
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
                    v.getId(),
                    v.getId(), road);
            if (!this.edges.containsValue(edge))
                this.addEdge(edge);
        }
    }
}
