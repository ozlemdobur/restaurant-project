package com.restaurant.service;


import com.restaurant.model.User;

public interface UserService {

    Iterable<User> findAll();
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long Id);
    User findById(Long id);
}
