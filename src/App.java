import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import map.Map;
import services.CsvReader;
import services.DecoStrings;

public class App {
    public static void main(String[] args) {
        Map map = new Map();
        loadFileToMap(map);
    }

    public static void loadFileToMap(Map map) {
        File br = new File("../src/database/br.csv");
        System.out.println(DecoStrings.RED("path = " + br.getAbsolutePath()));
        System.out.println(br.exists());
        ArrayList<String> linesOfFile = new ArrayList<>();
        try {
            linesOfFile.addAll(CsvReader.read(br));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(linesOfFile.toString());
    }
}
