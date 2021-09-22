package com.example.listingapp.service;

import com.example.listingapp.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();


    Optional<User> findById(int id);

    User save(User user);

    void deleteById(int id);
}

