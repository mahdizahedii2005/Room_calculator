package org.example.handler;


import org.example.user.Person;

public class DefaultMessageBuilder {
    public String build(Person[] users) {
        String message = "please first enter the username of the user that pay for this\n" +
                "then enter amount of the money that you pay\n" +
                "Then enter the usernames of the people who share this cost \n" +
                "like this :\n\n" +
                "hasani\n" +
                "1000.5\n" +
                "zahedi\n" +
                "hasani\n" +
                "mostajeran\n\n\n" +
                "all of the username of the users are\n{{{\n";
        for (var user : users) {
            message += user.userName + "\n";
        }
        message += "}}}";
        return message;
    }
}
