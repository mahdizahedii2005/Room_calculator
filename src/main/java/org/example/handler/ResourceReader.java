package org.example.handler;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ResourceReader {
    private final String path = "src\\main\\java\\org\\example\\user\\userNames.txt";
    private final File file = new File(path);

    public ArrayList<String> read() throws FileNotFoundException {
        ArrayList<String> userNames = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            userNames.add(scanner.nextLine());
        }
        return userNames;
    }
}
