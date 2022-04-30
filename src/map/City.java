package map;

import graph.components.vertex.ValorableVertex;

public class City extends ValorableVertex<Integer> {
    private Double lat;
    private Double lng;

    public City(String name, Double lat, Double lng, int population) {
        super(name, population);
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return this.getLabel();
    }

    public void setName(String name) {
        this.setLabel(name);
    }

    public Integer getPopulation() {
        return this.getValue();
    }

    public void setPopulation(Integer population) {
        this.setValue(population);
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "(" + this.lat + ", " + this.getLng() + ")";
    }
}
