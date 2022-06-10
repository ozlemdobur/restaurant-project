package com.restaurant.repository;

import com.restaurant.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    //User findByUserNameAndPassword(String userName, String password);

}
