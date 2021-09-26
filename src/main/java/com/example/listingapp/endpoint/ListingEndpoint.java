package com.example.listingapp.endpoint;

import com.example.listingapp.model.Listing;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ListingEndpoint {

    private final ListingService listingService;

    @GetMapping("/listings")
    public List<Listing> listings(){
        return  listingService.findAll();
    }

    @GetMapping("/listings/{id}")
    public Listing  getListing(@PathVariable("id") int id){

        return  listingService.getListingById(id);
    }

    @GetMapping("/listings/byUser/{email}")
    public Listing getByEmail(@PathVariable("email") String email){

        return listingService.getByUserEmail(email);
    }


    @GetMapping("/listings/byCategory/{categoryId}")
    public Optional<Listing> getByCategoryId(@PathVariable("categoryId")int id){

        return  listingService.getByCategoryId(id);
    }

    @PostMapping("/listings")
    public Listing listing(@RequestBody Listing listing){
        return listingService.save(listing);
    }
    @PutMapping("listings/{id}")
    public ResponseEntity<Listing> listing(@PathVariable("id") int id,@RequestBody Listing listing){
        Optional<Listing> byId=listingService.findById(id);
        if (!byId.isPresent()){
            return ResponseEntity
                    .notFound()
                    .build();
        }
        Listing  listingFromDb=byId.get();
        listingFromDb.setTitle(listing.getTitle());
        listingFromDb.setDescription(listing.getDescription());
        listing.setPrice(listing.getPrice());
        listing.setCategory(listing.getCategory());
        listing.setUser(listing.getUser());
        return ResponseEntity.ok().body(listingService.save(listingFromDb));
    }
    @DeleteMapping("/listings/{id}")
    public ResponseEntity<Listing> deleteById(@PathVariable("id") int id){
        Optional<Listing> byId=listingService.findById(id);
        if (!byId.isPresent()){
            return ResponseEntity
                    .notFound()
                    .build();
        }
        listingService.deleteById(id);

        return  ResponseEntity
                .noContent()
                .build();
    }
}
