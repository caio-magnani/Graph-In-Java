import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import map.Map;
import services.CsvReader;

public class App {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Map m;
        try {
            m = new Map(CsvReader.loadFile(args[0]));
        } catch (IndexOutOfBoundsException e) {
            m = new Map(CsvReader.loadFile("br.csv"));
        }
        System.out.println(m);
    }
}
