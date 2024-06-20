package com.example.springapi.service;

import com.example.springapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> userList;

    public UserService() {
        userList = new ArrayList<>();
        User user1 = new User(1, "Ida", 32, "ida@gmail.com");
        User user2 = new User(2, "Hans", 26, "hans@mail.com");
        User user3 = new User(3, "Lars", 45, "lars@mail.com");
        User user4 = new User(4, "Ben", 32, "ben@mail.com");
        User user5 = new User(5, "Eva", 59, "eva@mail.com");
        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
    }

    public Optional<User> getUser(Integer id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst();
    }

    public User addUser(User user) {
        userList.add(user);
        return user;
    }

    public User updateUser(Integer id, User updatedUser) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getId() == id) {
                userList.set(i, updatedUser);
                return updatedUser;
            }
        }
        return null;
    }

    public boolean deleteUser(Integer id) {
        return userList.removeIf(user -> user.getId() == id);
    }
}
