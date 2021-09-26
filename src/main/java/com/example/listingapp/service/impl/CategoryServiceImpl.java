package com.example.listingapp.service.impl;

import com.example.listingapp.model.Category;
import com.example.listingapp.repository.CategoryRepository;
import com.example.listingapp.repository.UserRepository;
import com.example.listingapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        {
            return categoryRepository.findAll();
        }
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {

    }
}
