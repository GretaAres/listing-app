package com.example.listingapp.service.impl;

import com.example.listingapp.model.Category;
import com.example.listingapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Optional<Category> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
