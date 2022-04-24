package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvReader {
    public static String[] read(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<String> strs = new ArrayList<>();
        while (scanner.hasNextLine()) {
            strs.add(scanner.nextLine());
        }
        scanner.close();
        return (String[]) strs.toArray();
    }
}
