package pl.edu.wat.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.demo.dtos.BikeRequest;
import pl.edu.wat.demo.dtos.BikeResponse;
import pl.edu.wat.demo.dtos.UserRequest;
import pl.edu.wat.demo.dtos.UserResponse;
import pl.edu.wat.demo.services.ReservationService;
import pl.edu.wat.demo.services.UserService;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/user")
    public ResponseEntity addNew(@RequestBody UserRequest userRequest) {
        userService.addNew(userRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PutMapping("/api/user/{user_id}")
    public ResponseEntity update(@PathVariable int user_id, @RequestBody UserRequest userRequest) {
        userService.update(userRequest, user_id);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @GetMapping("/api/user")
    public ResponseEntity<List<UserResponse>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/api/user/{user_id}")
    public ResponseEntity<UserResponse> getById(@PathVariable int user_id) {
        return new ResponseEntity<>(userService.getById(user_id), HttpStatus.OK);
    }

    @DeleteMapping("/api/user/{user_id}")
    public ResponseEntity deleteById(@PathVariable int user_id) {
        userService.deleteById(user_id);
        return new ResponseEntity(HttpStatus.OK);
    }


}