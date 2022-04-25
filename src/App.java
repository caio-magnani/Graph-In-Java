import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import map.Map;
import map.City;
import services.DecoStrings;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Map map = new Map();
        loadMap(map);
        map.generateAllRoadWays();
        System.out.println(map);
        map.print();
    }

    public static void loadMap(Map map) {
        ArrayList<String> strs = new ArrayList<>();
        try {
            loadFile(strs);
        } catch (FileNotFoundException e) {
            System.out.println(DecoStrings.RED(e.getMessage()));
        }
        for (String s : strs) {
            String[] infos = s.split(",");
            map.addACity(new City(infos));
        }
    }

    public static ArrayList<String> loadFile(ArrayList<String> strs) throws FileNotFoundException {
        FileInputStream br = new FileInputStream("br.csv");
        InputStreamReader isr = new InputStreamReader(br);
        BufferedReader reader = new BufferedReader(isr);
        String line = "";
        try {
            reader.readLine();
            do {
                line = reader.readLine();
                strs.add(line);
            } while (line != null);
            strs.remove(strs.size() - 1);
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            return null;
        }
        return strs;
    }
}
