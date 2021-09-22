package com.example.listingapp.endpoint;

import com.example.listingapp.model.Category;
import com.example.listingapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CategoryEndpoint {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> categories(){
        return  categoryService.findAll();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") int id){
        Optional<Category> byId=categoryService.findById(id);
        if (!byId.isPresent()){
            return ResponseEntity
                    .notFound()
                    .build();
        }
        return  ResponseEntity.ok(byId.get());
    }
    @PostMapping("/categories")
    public Category category(@RequestBody Category category){
        return categoryService.save(category);
    }
    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> category(@PathVariable("id") int id,@RequestBody Category category){
        Optional<Category> byId=categoryService.findById(id);
        if (!byId.isPresent()){
            return ResponseEntity
                    .notFound()
                    .build();
        }
        Category categoryFromDb=byId.get();
        categoryFromDb.setName(category.getName());
        return ResponseEntity.ok().body(categoryService.save(categoryFromDb));
    }
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Category> deleteById(@PathVariable("id") int id){
        Optional<Category> byId=categoryService.findById(id);
        if (!byId.isPresent()){
            return ResponseEntity
                    .notFound()
                    .build();
        }
        categoryService.deleteById(id);

        return  ResponseEntity
                .noContent()
                .build();
    }
}
