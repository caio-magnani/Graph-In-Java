package map;

public class RoadWay {
    private String name;

    public RoadWay(City c1, City c2) {
        this.name = c1.getName() + "<-->" + c2.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
