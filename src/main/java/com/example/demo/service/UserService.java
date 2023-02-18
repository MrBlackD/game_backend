package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    private static Map<String, User> users = new HashMap<>();

    public User addUser(String name) {
        String userId = UUID.randomUUID().toString();
        User user = new User(userId, name);
        users.put(userId, user);
        return user;
    }

    public User rename(String userId, String name) {
        User user = users.get(userId);
        user.setName(name);
        return user;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }
}
