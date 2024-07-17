package com.ngocha.identity_service.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.ngocha.identity_service.dto.request.ApiResponse;
import com.ngocha.identity_service.dto.request.UserCreationRequest;
import com.ngocha.identity_service.dto.request.UserUpdateRequest;
import com.ngocha.identity_service.dto.response.UserResponse;
import com.ngocha.identity_service.entity.User;
import com.ngocha.identity_service.service.Userservice;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/users")
public class UserController {
    Userservice userservice;

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userservice.createRequest(request));
        return apiResponse;
    }

    @GetMapping
    List<User> getUsers() {
        return userservice.getUsers();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable String userId) {
        return userservice.getUser(userId);
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userservice.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userservice.deleteUser(userId);
        return "Delete User Successfully!";
    }
}
