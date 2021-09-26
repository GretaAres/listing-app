package com.example.listingapp.repository;

import com.example.listingapp.model.Listing;
import com.example.listingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ListingRepository extends JpaRepository<Listing,Integer> {

    Listing findByUser(User user);

    Listing findByUser_Email(String email);

    Optional<Listing> findByCategory_Id(int categoryId);
}
