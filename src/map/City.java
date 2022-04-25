package map;

import java.math.BigInteger;

import graph.components.vertex.ValorableVertex;

public class City extends ValorableVertex<BigInteger> {
    private int lat;
    private int lng;

    public City(String name, Integer lat, Integer lng, BigInteger population) {
        super(name, population);
        this.lat = lat;
        this.lng = lng;
    }

    // 0, 1, 2, 3, 4, 5, 6, 7, 8
    // São Paulo,-23.5504,-46.6339,Brazil,BR,São Paulo,admin,22046000,12252023
    public City(String[] infos) {
        super(infos[0], new BigInteger(infos[8]));
        this.lat = Math.round(new Float(infos[1]));
        this.lng = Math.round(new Float(infos[2]));
    }

    public String getName() {
        return this.getLabel();
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLng() {
        return lng;
    }

    public void setLng(Integer lng) {
        this.lng = lng;
    }

    public BigInteger getPopulation() {
        return super.getValue();
    }

    public void setPopulation(BigInteger population) {
        super.setValue(population);
    }

    @Override
    public String toString() {
        return this.getName() + " have a population of " + this.getPopulation() + " people";
    }
}
