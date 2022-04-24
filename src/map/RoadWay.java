package map;

import graph.components.edge.undirectional.ValorableUndirectionalEdge;

public class RoadWay extends ValorableUndirectionalEdge<Double> implements Comparable<RoadWay> {

    public RoadWay(String name, int v1, int v2, Double distence) {
        super(name, v1, v2, distence);
    }

    public String getName() {
        return this.getLabel();
    }

    public Double getDistance() {
        return this.getValue();
    }

    public static Double getDistanceBetween(City c1, City c2) {
        int x = c1.getLat() - c2.getLat();
        int y = c1.getLng() - c2.getLng();
        int deslocation = (int) Math.round(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
        return RoadWay.parseDegreesDeslocationToKm(deslocation);
    }

    public static Double parseDegreesDeslocationToKm(Integer deslocation) {
        return (double) deslocation * 111.045F;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.getName() + " with a " + this.getDistance() + "km";
    }

    @Override
    public int compareTo(RoadWay o) {
        if (this.getDistance() == o.getDistance())
            return 0;
        if (this.getDistance() > o.getDistance())
            return 1;
        return -1;
    }
}
