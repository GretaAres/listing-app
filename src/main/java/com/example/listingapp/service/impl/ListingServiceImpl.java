package com.example.listingapp.service.impl;

import com.example.listingapp.model.Category;
import com.example.listingapp.model.Listing;
import com.example.listingapp.model.User;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ListingServiceImpl implements ListingService {
    @Override
    public List<Listing> findAll() {
        return null;
    }

    @Override
    public Optional<Listing> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Listing> findByUser(User user) {
        return Optional.empty();
    }

    @Override
    public Optional<Listing> findByCategoryId(Category category) {
        return Optional.empty();
    }

    @Override
    public Listing save(Listing listing) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
