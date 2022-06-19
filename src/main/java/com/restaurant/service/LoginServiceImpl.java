package com.restaurant.service;

import com.restaurant.model.Personnel;
import com.restaurant.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    private LoginRepository loginRepository;

    public LoginServiceImpl() {
    }
    @Autowired
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Personnel login(String username, String password) {
        Personnel personnel = loginRepository.findByUsernameAndPassword(username, password);
        return personnel;
    }
}
