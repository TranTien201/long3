package com.example.long3.Service;

import com.example.long3.Model.User;

import java.util.Optional;

public interface UserService {
    void addUser(String userName, String email, String password);
    User loginUser(String email, String password);

    boolean checkEmailExist(String email);
    boolean checkRePassword(String password, String re_password);

    Optional<User> getUserByName(String name);

    Long countUserID();

    Optional<User> getUserByID(String id);

    void updateUser(User u);
}
