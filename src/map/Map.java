package map;

import java.util.ArrayList;

import graph.ValorableUndirectionalGraph;
import graph.components.vertex.Vertex;

public class Map extends ValorableUndirectionalGraph<City, RoadWay> {
    public static final Double RADIO_OF_EARTH = Double.parseDouble("6378.1370");
    public Map() {
        super();
    }
    public Map(ArrayList<String> infos){
        super();
        for (String str : infos) {
            String[] s = str.split(",");
            this.addCity(new City(s[0], Double.parseDouble(s[1]), Double.parseDouble(s[2]), Integer.parseInt(s[8])));
        }
        generateRoads();
    }

    private void generateRoads() {
        for (City c : this.matrix.getAllVertexs()) {
            generateRoadsOf(c);   
        }
    }

    private void generateRoadsOf(City v){
        for (City c : this.matrix.getAllVertexs()) {
            RoadWay road = new RoadWay(c, v);
            if((!this.matrix.getAllEdges().contains(road)) && !(road.getV1()==road.getV2()))
                this.addRoad(road);
        }
    }

    public static Double toRad(Double value) {
        return value * Math.PI / 180;
    }

    

    public void addCity(City c) {
        addComponent(c);
    }

    public void addRoad(RoadWay road) {
        addComponent(road);
    }
}
