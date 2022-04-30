package services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class CsvReader {
    public static ArrayList<String> loadFile(String namefile)
            throws FileNotFoundException, UnsupportedEncodingException {

        ArrayList<String> strs = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("br.csv"), "UTF-8"));

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
