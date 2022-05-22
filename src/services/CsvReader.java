package services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class CsvReader {
    // Le o csv e retorna um array de strings que contem cada linha do arquivo
    public static ArrayList<String> loadFile(String namefile)
            throws FileNotFoundException, UnsupportedEncodingException {

        // Armazenar as linhas do csv em um Array List
        ArrayList<String> lines = new ArrayList<>();

        // Configurando o reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("br.csv"), "UTF-8"));

        String line = "";

        try {
            // Le a primeira linha e nao armazeno no array
            reader.readLine();
            do {
                // Le a linha e adiciona no array de linhas
                line = reader.readLine();
                lines.add(line);
            } while (line != null || line == "\n");
            // Remove a ultima linha vazia
            lines.remove(lines.size() - 1);
            reader.close();
        } catch (IOException e) {
            return null;
        }
        return lines;
    }
}
