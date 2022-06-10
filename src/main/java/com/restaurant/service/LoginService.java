package com.restaurant.service;

import com.restaurant.model.User;

public interface LoginService {
    User login(String username,String password);
}
