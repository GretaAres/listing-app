package com.example.listingapp.service;

import com.example.listingapp.model.Category;
import com.example.listingapp.model.Listing;
import com.example.listingapp.model.User;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface ListingService {

    List<Listing> findAll();

    Optional<Listing> findById(int id);

    Optional<Listing> findByUser(User user);

    Optional<Listing> findByCategoryId(Category category);

    Listing save(Listing listing);

    void deleteById(int id);
}
