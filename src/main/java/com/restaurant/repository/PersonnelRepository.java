package com.restaurant.repository;

import com.restaurant.model.Personnel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends CrudRepository<Personnel, Long> {

    //User findByUserNameAndPassword(String userName, String password);

}
