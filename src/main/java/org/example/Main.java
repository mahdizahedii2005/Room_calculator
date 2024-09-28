package org.example;


import org.example.app.Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            new Thread(new Application(new Scanner(new File("src/main/java/org/example/data/token.txt")).nextLine()))
                    .start();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
