package graph.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import graph.Graph;

public class Map extends Graph<City, RoadWay> {
    public static final Double RADIO_OF_EARTH = Double.parseDouble("6378.1370");

    public Map() {
        super();
    }

    public Map(ArrayList<String> objects) {
        super();
        for (String object : objects) {
            String[] params = object.split(",");
            // s[0] = Nome
            // s[1] = Latitude
            // s[2] = Longetude
            this.addComponent(new City(params[0], Double.parseDouble(params[1]), Double.parseDouble(params[2]),
                    Integer.parseInt(params[8])));
        }
        generateRoads();
    }

    public void generateRoads() {
        ArrayList<City> cities = this.getAllVertexs();
        for (City c : this.getAllVertexs()) {
            cities.remove(c);
            generateRoadsOf(c, cities);
        }
        // filterRoadWays();
    }

    private void generateRoadsOf(City c, ArrayList<City> cities) {
        for (City city : cities) {
            RoadWay road = new RoadWay(c, city);
            this.addComponent(road);
        }
    }

    public ArrayList<RoadWay> the3Closest(City c) {
        ArrayList<RoadWay> roadWays = this.getAllEdgesOf(c.getId());
        Collections.sort(roadWays);
        ArrayList<RoadWay> returnRoadWays = new ArrayList<>();
        try {
            returnRoadWays.addAll(roadWays.subList(0, 3));
            return returnRoadWays;
        } catch (IndexOutOfBoundsException e) {
            return roadWays;
        }
    }

    public String stringAllCitys() {
        String s = new String();
        for (City c : this.getAllVertexs()) {
            s += c + "\n";
        }
        return s;
    }

    public City getCity(int id) {
        return this.getVertex(id);
    }

    @Override
    public void addComponent(City c) {
        super.addComponent(c);
    }

    @Override
    public void removeComponent(RoadWay r) {
        super.removeComponent(r);
    }

    @Override
    public void addComponent(RoadWay r) {
        if (r.getV1() != r.getV2() && this.getEdge(r.getV1(), r.getV2()) == null) {
            super.addComponent(r);
        }
    }

    public void printEdges() {
        ArrayList<RoadWay> roadWays = this.getAllEdges();
        for (RoadWay roadWay : roadWays) {
            System.out.println(roadWay);
        }
    }

    public void printVertexs() {
        ArrayList<City> cities = this.getAllVertexs();
        for (City city : cities) {
            System.out.println(city);
        }

    }

    public String matrixToString() {
        return super.toString();
    }

    @Override
    public String toString() {
        String s = new String();
        ArrayList<City> cities = this.getAllVertexs();
        s += "Cities:\n";
        for (City city : cities) {
            s += city;
            ArrayList<RoadWay> roadWays = this.getAllEdgesOf(city.getId());
            s += "\nwith a road way of 3 closest citys:\n";
            Collections.sort(roadWays);
            for (int i = 0; i < 3; i++) {
                try {
                    s += roadWays.get(i) + "\n";
                } catch (IndexOutOfBoundsException e) {
                    // ignore
                }
            }
        }
        return s;
    }

    public static Double toRad(Double value) {
        return value * Math.PI / 180;
    }
}
