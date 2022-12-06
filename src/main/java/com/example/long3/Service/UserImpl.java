package com.example.long3.Service;

import com.example.long3.Model.User;
import com.example.long3.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    ServiceImpl service;
    @Override
        public void addUser(String userName, String email, String password) {
        String date = service.getDateTime();
        String memberID = "FPT" + (countUserID() + 1);
        System.out.println(memberID);
        User u = new User(memberID, userName, password, email, date, date);
        userRepository.save(u);
    }
    @Override
    public User loginUser(String email, String password) {
        User u = userRepository.loginUser(email, password);
        return u;
    }

    @Override
    public boolean checkEmailExist(String email) {
        User u = userRepository.checkEmailExist(email);
        return u != null;
    }

    @Override
    public boolean checkRePassword(String password, String re_password) {
        return password.equals(re_password);
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return Optional.empty();
    }

    @Override
    public Long countUserID() {
        return userRepository.countUserID();
    }

    @Override
    public Optional<User> getUserByID(String memberID) {
        return userRepository.findUserByID(memberID);
    }

    @Override
    public void updateUser(User u) {
        userRepository.save(u);
    }

}
