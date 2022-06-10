package com.restaurant.repository;

import com.restaurant.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
}
