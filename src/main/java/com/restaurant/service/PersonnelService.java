package com.restaurant.service;


import com.restaurant.model.Personnel;


public interface PersonnelService {

    public Iterable<Personnel> findAll();
    Personnel createPersonnel(Personnel personnel) throws Exception;
    void deletePersonnel(Long Id);
    Personnel findById(Long id);
}
