package org.example.handler;

import java.io.FileNotFoundException;
import java.util.Random;

public class MessageHandler {
    AllUserSaverAndReader allUserSaverAndReader;

    public MessageHandler() {
        allUserSaverAndReader = new AllUserSaverAndReader();
    }

    public String GetValidMessage(String messageText, long chatID) {
        if (messageText.equals("/start")) {
            try {
                allUserSaverAndReader.saveString(chatID);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            return "Welcome! You are now subscribed.";
        }
        else if (messageText.equals("/dice")) {
            int number = new Random().nextInt(6);
            switch (number) {
                case 0 -> {
                    return "cheater";
                }
                case 1 -> {
                    return "khayemal";
                }
                case 2 -> {
                    return "haj khanoom baz";
                }
                case 3 -> {
                    return "batman";
                }
                case 4 -> {
                    return "zhigantism";
                }
                case 5 -> {
                    return "golden 30 cm";
                }
            }
        }
        else if (messageText.equals("/")) {
        } else {
            return "wtf??";
        }
        return null;
    }
}
