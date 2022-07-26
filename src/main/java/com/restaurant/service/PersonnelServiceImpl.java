package com.restaurant.service;

import com.restaurant.authorization.Session;
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
    public Personnel createPersonnel(Personnel personnel) throws Exception{
        if(isPasswordStrong(personnel)){
            Personnel personnelCreated = personnelRepository.save(personnel);
            Session.addUser(personnel.getUsername(), personnel.getRole());
            return personnelCreated;
        }
        throw new Exception("Password is weak!");
    }

    @Override
    public void deletePersonnel(Long Id) {
        personnelRepository.deleteById(Id);
    }

    @Override
    public Personnel findById(Long id) {
        return null;
    }

    public boolean isPasswordStrong(Personnel personnel){
                //String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
                String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.]).{8,}$";
                return (personnel.getPassword().matches(pattern));

    }

}
