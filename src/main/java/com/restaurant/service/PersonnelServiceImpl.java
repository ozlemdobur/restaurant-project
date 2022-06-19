package com.restaurant.service;

import com.restaurant.model.Personnel;
import com.restaurant.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonnelServiceImpl implements PersonnelService {

    private PersonnelRepository personnelRepository;

    public PersonnelServiceImpl() {
    }

    @Autowired
    public PersonnelServiceImpl(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    @Override
    public Iterable<Personnel> findAll() {
        Iterable<Personnel> personnels = personnelRepository.findAll();
        return personnels;
    }

    @Override
    public Personnel createPersonnel(Personnel personnel) {
        Personnel personnelCreated = personnelRepository.save(personnel);
        return personnelCreated;
    }

    @Override
    public Personnel updatePersonnel(Personnel personnel) {
        Personnel personnelUpdated = findById(personnel.getId());
        personnelUpdated.setFirstName(personnel.getFirstName());
        personnelUpdated.setLastName(personnel.getLastName());
        personnelUpdated.setUsername(personnel.getUsername());
        personnelUpdated.setPassword(personnel.getPassword());
        personnelUpdated.setRole(personnel.getRole());
        return personnelRepository.save(personnelUpdated);
    }

    @Override
    public void deletePersonnel(Long Id) {
        personnelRepository.deleteById(Id);
    }

    @Override
    public Personnel findById(Long id) {
        return null;
    }


}
