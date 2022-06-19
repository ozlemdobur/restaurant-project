package com.restaurant.service;


import com.restaurant.model.Personnel;


public interface PersonnelService {

    Iterable<Personnel> findAll();
    Personnel createPersonnel(Personnel personnel);
    Personnel updatePersonnel(Personnel personnel);
    void deletePersonnel(Long Id);
    Personnel findById(Long id);
}
