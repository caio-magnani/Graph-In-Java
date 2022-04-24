package map;

import java.math.BigInteger;

import graph.components.vertex.ValorableVertex;

public class City extends ValorableVertex<BigInteger> {
    private int lat;
    private int lng;
    private BigInteger population;

    public City(String name, Integer lat, Integer lng, BigInteger population) {
        super(name, population);
        this.lat = lat;
        this.lng = lng;
        this.population = population;
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
        return population;
    }

    public void setPopulation(BigInteger population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return this.getName() + " have a population of " + this.getPopulation() + " people";
    }
}
