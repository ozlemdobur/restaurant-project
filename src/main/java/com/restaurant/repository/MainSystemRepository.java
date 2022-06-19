package com.restaurant.repository;

import com.restaurant.model.Personnel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainSystemRepository extends CrudRepository<Personnel, Long> {
    Personnel findByUsername(String username);
}
