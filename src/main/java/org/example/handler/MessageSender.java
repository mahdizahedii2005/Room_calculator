package org.example.handler;


import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;

import java.io.FileNotFoundException;

public class MessageSender implements sender {
    TelegramBot bot;
    private static AllUserSaverAndReader allUserSaverAndReader = new AllUserSaverAndReader();

    public MessageSender(TelegramBot bot) {
        this.bot = bot;
    }

    @Override
    public void send(String message) throws FileNotFoundException {
        for (var chatId:allUserSaverAndReader.getListOfAllUser()){
            send(message,chatId);
            System.out.println("message " + message +"was send to the "+chatId);
        }
    }

    @Override
    public void send(String message, long chatId) {
        System.out.println("i want to send message {" + message +"} to the "+chatId);
        bot.execute(new SendMessage(chatId,message));
        System.out.println("message " + message +"was send to the "+chatId);

    }
}
