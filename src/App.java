import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import map.Map;
import services.CsvReader;

public class App {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Map m = new Map(CsvReader.loadFile());
        System.out.println(m);
    }
}
