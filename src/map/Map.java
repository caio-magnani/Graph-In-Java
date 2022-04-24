package map;

import java.util.TreeMap;

import graph.ValorableUndirectionalGraph;

public final class Map extends ValorableUndirectionalGraph<City, RoadWay> {

    public Map() {
        super(new TreeMap<Integer, City>(), new TreeMap<Integer, RoadWay>());
    }

    public boolean addACity(City c) {
        return addVertex(c);
    }

    public City getCity(String name) {
        return (City) this.getVertex(name);
    }

    public boolean addRoadWay(City c1, City c2) {
        int v1 = super.getPositionVertex(c1);
        int v2 = super.getPositionVertex(c2);
        if (v1 == 0)
            return false;
        if (v2 == 0)
            return false;
        return addEdge(new RoadWay(c1.getName() + " to " + c2.getName(), v1, v2, RoadWay.getDistanceBetween(c1, c2)));
    }

    public RoadWay getRoadWay(String name) {
        return (RoadWay) this.getEdge(name);
    }

}
