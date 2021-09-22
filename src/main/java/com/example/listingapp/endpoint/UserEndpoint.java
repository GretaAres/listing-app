package com.example.listingapp.endpoint;

import com.example.listingapp.model.User;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserEndpoint {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> users(){
        return  userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        Optional<User> byId=userService.findById(id);
        if (!byId.isPresent()){
            return ResponseEntity
                    .notFound()
                    .build();
        }
        return  ResponseEntity.ok(byId.get());
    }
    @PostMapping("/users")
    public User user(@RequestBody User user){
        return userService.save(user);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> user(@PathVariable("id") int id,@RequestBody User user){
        Optional<User> byId=userService.findById(id);
        if (!byId.isPresent()){
            return ResponseEntity
                    .notFound()
                    .build();
        }
        User userFromDb=byId.get();
        userFromDb.setName(user.getName());
        userFromDb.setSurname(user.getSurname());
        userFromDb.setRole(user.getRole());
        return ResponseEntity.ok().body(userService.save(userFromDb));
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteById(@PathVariable("id") int id){
        Optional<User> byId=userService.findById(id);
        if (!byId.isPresent()){
            return ResponseEntity
                    .notFound()
                    .build();
        }
        userService.deleteById(id);

        return  ResponseEntity
                .noContent()
                .build();
    }

}
