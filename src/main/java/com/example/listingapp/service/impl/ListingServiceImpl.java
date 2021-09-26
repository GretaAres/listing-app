package com.example.listingapp.service.impl;

import com.example.listingapp.model.Listing;
import com.example.listingapp.repository.ListingRepository;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;

    @Override
    public List<Listing> findAll() {
        return listingRepository.findAll();
    }

    @Override
    public Optional<Listing> findById(int id) {
        return listingRepository.findById(id);
    }

    @Override
    public Listing getByUserEmail(String email) {
        return listingRepository.findByUser_Email(email);
    }

    @Override
    public Optional<Listing> getByCategoryId(int categoryId) {
        return listingRepository.findByCategory_Id(categoryId);
    }

    @Override
    public Listing save(Listing listing) {
        return listingRepository.save(listing);
    }

    @Override
    public void deleteById(int id) {
        listingRepository.deleteById(id);

    }

    @Override
    public Optional<Listing> getListingById(int id) {
      return   listingRepository.findById(id);
    }

}
