package com.example.listingapp.service;

import com.example.listingapp.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    Optional<Category> findById(int id);

    Category save(Category category);

    void deleteById(int id);
}
