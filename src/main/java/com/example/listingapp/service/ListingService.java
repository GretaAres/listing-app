package com.example.listingapp.service;

import com.example.listingapp.model.Listing;

import java.util.List;
import java.util.Optional;

public interface ListingService {

     Listing getByUserEmail(String email) ;


    List<Listing> findAll();

    Optional<Listing> findById(int id);



    Listing save(Listing listing);

    void deleteById(int id);

    Optional<Listing> getListingById(int id);

    Optional<Listing> getByCategoryId(int id);
}
