package map;

import graph.components.edge.undirectional.ValorableUndirectionalEdge;
import services.DecoStrings;

public class RoadWay extends ValorableUndirectionalEdge<Double> {

    public RoadWay(City c1, City c2) {
        super(c1.getName() + " <---> " + c2.getName(), c1.getId(), c2.getId(), calculateDistance(c1, c2));
    }

    private static Double calculateDistance(City c1, City c2) {
        final int R = 6371; // Radious of the earth
        Double lat1 = c1.getLat();
        Double lon1 = c1.getLng();
        Double lat2 = c2.getLat();
        Double lon2 = c2.getLng();
        Double latDistance = Map.toRad(lat2-lat1);
        Double lonDistance = Map.toRad(lon2-lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
        Math.cos(Map.toRad(lat1)) * Math.cos(Map.toRad(lat2)) * 
        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }

    public String getName() {
        return this.getLabel();
    }

    public void setName(String name) {
        this.setLabel(name);
    }

    public Double getDistance() {
        return this.getValue();
    }

    @Override
    public String infos() {
        return super.infos() + DecoStrings.GREEN(", Distance = " + this.getDistance());
    }

}
