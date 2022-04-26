package map;

public class City {
    private String name;
    private Integer population;
    private Double lat;
    private Double lng;

    public City(String name, Double lat, Double lng, int population) {
        this.name = name;
        this.population = population;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
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
        return "lat -> " + getLat() + ", lng -> " + getLng() + ", population -> " + getPopulation();
    }
}
