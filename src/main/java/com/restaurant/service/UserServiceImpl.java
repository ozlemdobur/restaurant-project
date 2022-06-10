package com.restaurant.service;

import com.restaurant.model.User;
import com.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> findAll() {
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User createUser(User user) {
        User userCreated = userRepository.save(user);
        return userCreated;
    }

    @Override
    public User updateUser(User user) {
        User userUpdated = findById(user.getId());
        userUpdated.setFirstName(user.getFirstName());
        userUpdated.setLastName(user.getLastName());
        userUpdated.setUsername(user.getUsername());
        userUpdated.setPassword(user.getPassword());
        userUpdated.setRole(user.getRole());
        return userRepository.save(userUpdated);
    }

    @Override
    public void deleteUser(Long Id) {
        userRepository.deleteById(Id);
    }

    @Override
    public User findById(Long id) {
        return null;
    }


}
