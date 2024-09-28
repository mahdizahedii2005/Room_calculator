package org.example.app;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import org.example.handler.*;
import org.example.user.Person;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application implements Runnable {
    TelegramBot bot;
    MessageSender sender;
    MessageHandler messageHandler;

    public Application(String token) {
        bot = new TelegramBot(token);
        this.sender = new MessageSender(bot);
        messageHandler = new MessageHandler();
    }

    private void sendTheGuideMessage(Person[] users) {
        String DefaultMessage = new DefaultMessageBuilder().build(users);
        try {
            sender.send(DefaultMessage);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        Person[] users = null;
        try {
            users = new UserBuilder().Build(new ResourceReader().read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sendTheGuideMessage(users);
        bot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                if (update.message() != null && update.message().text() != null) {
                    String messageText = update.message().text();
                    long chatId = update.message().chat().id();
                    System.out.println("i get the message { " + messageText+" }");
                    sender.send(messageHandler.GetValidMessage(messageText, chatId), chatId);
                }
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}
