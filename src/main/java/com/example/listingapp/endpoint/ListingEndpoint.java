package com.example.listingapp.endpoint;

import com.example.listingapp.model.Category;
import com.example.listingapp.model.Listing;
import com.example.listingapp.model.User;
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
    public ResponseEntity<Listing> getListing(@PathVariable("id") int id){
        Optional<Listing> byId=listingService.findById(id);
        if (!byId.isPresent()){
            return ResponseEntity
                    .notFound()
                    .build();
        }
        return  ResponseEntity.ok(byId.get());
    }

    @GetMapping("/listings/byUser/{email}")
    public ResponseEntity<Listing> getListingByUser(@PathVariable("email") User user){
        Optional<Listing> byEmail=listingService.findByUser(user);
        if (!byEmail.isPresent()){
            return ResponseEntity
                    .notFound()
                    .build();
        }
        return  ResponseEntity.ok(byEmail.get());
    }


    @GetMapping("/listings/bycategory/{categoryId}")
    public ResponseEntity<Listing> getListingByCategory(@PathVariable("categoryId")Category category){
        Optional<Listing> byCategoryId=listingService.findByCategoryId(category);
        if (!byCategoryId.isPresent()){
            return ResponseEntity
                    .notFound()
                    .build();
        }
        return  ResponseEntity.ok(byCategoryId.get());
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
