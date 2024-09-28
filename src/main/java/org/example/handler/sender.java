package org.example.handler;


import java.io.FileNotFoundException;

public interface sender {
    void send(String message) throws FileNotFoundException;

    void send(String message, long chatId);
}
