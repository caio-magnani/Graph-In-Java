package map;

import java.util.TreeMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Map.Entry;

import graph.ValorableUndirectionalGraph;

public final class Map extends ValorableUndirectionalGraph<City, RoadWay> {

    public Map() {
        super(new TreeMap<Integer, City>(), new TreeMap<Integer, RoadWay>());
    }

    public ArrayList<RoadWay> get3RoadWayCloserOf(City c) {
        ArrayList<RoadWay> rWs = new ArrayList<>();
        rWs.addAll(this.getRoadWaysOf(c).stream().limit(3).toList());
        return rWs;
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
        RoadWay newer = new RoadWay(c1.getName() + " to " + c2.getName(), v1, v2, RoadWay.getDistanceBetween(c1, c2));
        if (v1 == 0)
            return false;
        if (v2 == 0)
            return false;
        if (this.edges.containsValue(newer))
            return false;
        return addEdge(new RoadWay(c1.getName() + " to " + c2.getName(), v1, v2, RoadWay.getDistanceBetween(c1, c2)));
    }

    public RoadWay getRoadWay(String name) {
        return (RoadWay) this.getEdge(name);
    }

    public RoadWay getRoadWay(int v1, int v2) {
        RoadWay thisRW = new RoadWay("", v1, v2, Double.MAX_VALUE);
        for (Entry<Integer, RoadWay> e : this.edges.entrySet()) {
            System.out.println("getRoadWay(v1,v2)");
            System.out.println("thisRW = " + thisRW);
            System.out.println("e = " + e.getValue());
            System.out.println("equals = " + e.getValue().equals(thisRW));
            if (e.getValue().equals(thisRW))
                return e.getValue();
        }
        return null;
    }

    public ArrayList<RoadWay> getRoadWaysOf(City c) {
        ArrayList<RoadWay> rWs = new ArrayList<RoadWay>();
        int positionC = this.getPositionVertex(c);
        for (Entry<Integer, RoadWay> e : this.edges.entrySet()) {
            if ((e.getValue().getV1() == positionC || e.getValue().getV2() == positionC)
                    && e.getValue().getDistance() != null) {
                rWs.add(e.getValue());
            }
        }
        Collections.sort(rWs);
        return rWs;
    }

    public void generateAllRoadWays() {
        for (Entry<Integer, City> e : this.vertexs.entrySet()) {
            generateAllRoadWaysOf(e.getValue());
        }
    }

    public void generateAllRoadWaysOf(City c) {
        for (Entry<Integer, City> e : this.vertexs.entrySet()) {
            if (!e.getValue().equals(c)) {
                this.addRoadWay(c, e.getValue());
            }
        }
    }

    public void print() {
        String str = new String();
        for (City c : this.vertexs.values()) {
            str += c.toString();
            str += "\n 3 city closer\n";
            str += this.get3RoadWayCloserOf(c).toString();
            str += "\n\n";
        }
        System.out.println(str);
    }

}
