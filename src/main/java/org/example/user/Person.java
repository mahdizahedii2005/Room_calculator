package org.example.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Person {
    public String userName;
    public double amount;
    public File userFile;

    public Person(String userName) throws IOException {
        this.userName = userName;
        this.amount = 0;
        userFile = new File("src\\main\\java\\org\\example\\user\\" + userName + ".txt");
        if (userFile.exists()) {
            update();
        } else {
            userFile.createNewFile();
            upload();
        }
    }

    public void upload() throws IOException {
        PrintWriter printWriter = new PrintWriter(userFile);
        printWriter.println(amount);
        printWriter.flush();
        printWriter.close();
    }

    public void update() throws FileNotFoundException {
        Scanner fileReader = new Scanner(userFile);
        amount = Double.parseDouble(fileReader.nextLine());
        fileReader.close();
    }

    public void clearTheAmount() throws IOException {
        amount = 0;
        upload();
    }
}
