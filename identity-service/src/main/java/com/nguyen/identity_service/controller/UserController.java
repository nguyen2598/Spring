package com.nguyen.identity_service.controller;


import com.nguyen.identity_service.dto.request.UserCreationRequest;
import com.nguyen.identity_service.dto.request.UserUpdateRequest;
import com.nguyen.identity_service.entity.User;
import com.nguyen.identity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/create")
    User createUser(@RequestBody @Valid UserCreationRequest request) {
       return userService.createUser(request);
        
    }

    @GetMapping("/all")
    List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable("userId") String userId,@RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId,request);
    }

    @DeleteMapping ("/{userId}")
    void updateUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
