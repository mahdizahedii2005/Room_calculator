package org.example.handler;


import org.example.user.Person;

import java.io.IOException;
import java.util.ArrayList;

public class UserBuilder {
    public Person[] Build(ArrayList<String> UserNames) throws IOException {
        Person[] people = new Person[UserNames.size()];
        int i = 0;
        for (String userName : UserNames) {
            people[i] = new Person(userName);
            i++;
        }
        return people;
    }
}
