package com.ngocha.identity_service.controller;

import com.ngocha.identity_service.dto.request.ApiResponse;
import com.ngocha.identity_service.dto.request.UserCreationRequest;
import com.ngocha.identity_service.dto.request.UserUpdateRequest;
import com.ngocha.identity_service.entity.User;
import com.ngocha.identity_service.service.Userservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private Userservice userservice;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userservice.createRequest(request));
        return apiResponse;
    }
    @GetMapping
    List<User> getUsers() {
        return userservice.getUsers();
    }
    @GetMapping("/{userId}")
    User getUser(@PathVariable String userId) {
        return userservice.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userservice.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userservice.deleteUser(userId);
        return "Delete User Successfully!";
    }

}
