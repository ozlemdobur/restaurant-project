package com.restaurant.service;

import com.restaurant.model.Personnel;
import com.restaurant.repository.MainSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainSystemServiceImpl implements MainSystemService{
    MainSystemRepository mainSystemRepository;

    @Autowired
    public MainSystemServiceImpl(MainSystemRepository mainSystemRepository) {
        this.mainSystemRepository = mainSystemRepository;
    }

    public Personnel getUser(String username) {
        Personnel personnel = mainSystemRepository.findByUsername(username);
        return personnel;
    }
}
