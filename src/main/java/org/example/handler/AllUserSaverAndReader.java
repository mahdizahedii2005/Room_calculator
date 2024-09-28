package org.example.handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AllUserSaverAndReader {
    private final String path = "src\\main\\java\\org\\example\\data\\allUserChatId.txt";
    private final File file = new File(path);

    public void saveString(long id) throws FileNotFoundException {
        String past = "";
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            var se = scanner.nextLine();
            if (Long.parseLong(se) == id) return;
            past += (se + "\n");
        }
        PrintWriter print = new PrintWriter(file);
        print.println(past  + id);
        print.flush();
        print.close();
    }

    public ArrayList<Long> getListOfAllUser() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<Long> result = new ArrayList<>();
        while (scanner.hasNextLine()) {
            result.add(Long.parseLong(scanner.nextLine()));
        }
        return result;
    }
}
