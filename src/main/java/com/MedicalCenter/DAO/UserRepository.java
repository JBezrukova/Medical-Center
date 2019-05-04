package com.MedicalCenter.DAO;

import com.MedicalCenter.entities.Record;
import com.MedicalCenter.entities.Request;
import com.MedicalCenter.entities.User;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository {

    private static UserRepository userRepository;
    private static AtomicInteger ID_COUNTER = new AtomicInteger(0);
    private ArrayList<User> users = new ArrayList<>();

    private UserRepository() {
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public boolean containsUserWithID(int id) {
        return users.stream()
                .map(User::getUser_id)
                .anyMatch(integer -> integer == id);
    }

    public User find(int id) {
        return users.stream()
                .filter(user -> user.getUser_id() == id)
                .findFirst().orElse(null);
    }

    public User find(String login) {
        return users.stream()
                .filter(user -> user.getLogin() == login)
                .findFirst().orElse(null);
    }

    public void add(User user) {
        if (user.getUser_id() == null) {
            user.setUser_id(ID_COUNTER.getAndIncrement());
        }
        for (User user1 : users) {
            if (user1.getUser_id() == user.getUser_id()) {
                users.remove(user1);
            }
        }
        users.add(user);
    }

    public void addRecord(Record record, User user) {
        if (!users.contains(user)) {
            add(user);
        }
        user.getRecords().add(record);
    }
}
