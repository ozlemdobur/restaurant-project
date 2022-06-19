package com.restaurant.service;

import com.restaurant.model.Personnel;


public interface LoginService {
    Personnel login(String username, String password);
}
