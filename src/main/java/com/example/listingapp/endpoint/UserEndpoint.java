package com.example.listingapp.endpoint;

import com.example.listingapp.dto.UserDto;
import com.example.listingapp.dto.UserSaveDto;
import com.example.listingapp.model.User;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserEndpoint {
    private final UserService userService;
    private final ModelMapper mapper;

    @GetMapping("/users")
    public List<UserDto> users(){
        List<User> all=userService.findAllUsers();
        List<UserDto> userDtos= new ArrayList<>();
        for(User user:all){
            UserDto userDto=mapper.map(user,UserDto.class);
            userDtos.add(userDto);
        }
        return  userDtos;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") int id){
        Optional<User> byId=userService.findById(id);
        if (!byId.isPresent()){
            return ResponseEntity
                    .notFound()
                    .build();
        }
        return  ResponseEntity.ok(mapper.map(byId.get(),UserDto.class));
    }
    @PostMapping("/users")
    public UserDto user(@RequestBody UserSaveDto user){
        return  mapper.map(userService.save(mapper.map(user,User.class)),UserDto.class);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> user(@PathVariable("id") int id,@RequestBody UserSaveDto user){
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
        return ResponseEntity
                .ok()
                .body(mapper.map(userService.save(userFromDb),UserDto.class));
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteById(@PathVariable("id") int id){
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
