package com.example.pp_3_1_2.dao;

import com.example.pp_3_1_2.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUser(int id);

    void saveUser(User user);

    void deleteUser(int id);
}
