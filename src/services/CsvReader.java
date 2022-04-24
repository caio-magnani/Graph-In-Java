package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvReader {
    public static ArrayList<String> read(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<String> strs = new ArrayList<>();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            strs.add(scanner.nextLine());
        }
        scanner.close();
        return strs;
    }
}
