package map;

import java.util.ArrayList;
import java.util.Collections;

import graph.ValorableUndirectionalGraph;

public class Map extends ValorableUndirectionalGraph<City, RoadWay> {
    public static final Double RADIO_OF_EARTH = Double.parseDouble("6378.1370");

    public Map() {
        super();
    }

    public Map(ArrayList<String> infos) {
        super();
        for (String str : infos) {
            String[] s = str.split(",");
            this.addCity(new City(s[0], Double.parseDouble(s[1]), Double.parseDouble(s[2]), Integer.parseInt(s[8])));
        }
        generateRoads();
    }

    private void generateRoads() {
        ArrayList<City> cities = this.matrix.getAllVertexs();
        for (City c : this.matrix.getAllVertexs()) {
            generateRoadsOf(c, cities);
            cities.remove(c);
        }
    }

    private void generateRoadsOf(City v, ArrayList<City> cities) {
        for (City c : cities) {
            RoadWay road = new RoadWay(c, v);
            this.addRoad(road);
        }
    }

    public ArrayList<RoadWay> the3Closest(City c) {
        ArrayList<RoadWay> roadWays = this.matrix.getAllEdgesOf(c);
        Collections.sort(roadWays);
        ArrayList<RoadWay> returnRoadWays =  new ArrayList<>();
        returnRoadWays.addAll(roadWays.subList(0, 3));
        return returnRoadWays;
    }

    public String stringAllCitys() {
        String s = new String();
        for (City c : this.matrix.getAllVertexs()) {
            s += c.toString() + "\n";
        }
        return s;
    }

    public static Double toRad(Double value) {
        return value * Math.PI / 180;
    }

    public void addCity(City c) {
        addComponent(c);
    }

    public City getCity(int id) {
        return this.getVertex(id);
    }

    public void addRoad(RoadWay road) {
        addComponent(road);
    }

    public void addComponent(RoadWay e) {
        int vertexPosition1 = this.getPositionOf(e.getV1());
        int vertexPosition2 = this.getPositionOf(e.getV2());
        if(vertexPosition1 != vertexPosition2){
            this.matrix.addValue(e, vertexPosition1, vertexPosition2);
            this.matrix.addValue(e, vertexPosition2, vertexPosition1);
        }
    }

    @Override
    public String toString() {
        String s = new String();
        ArrayList<City> cities = this.matrix.getAllVertexs();
        s+="Cities:\n";
        for (City city : cities) {
            s += city;
            ArrayList<RoadWay> roadWays = this.the3Closest(city);
            s += "with a road way of 3 closest citys:\n";
            for (RoadWay road : roadWays) {
                s += road+"\n";
            }
        }
        return s;
    }
}
