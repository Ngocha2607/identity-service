package com.ngocha.identity_service.controller;

import com.ngocha.identity_service.dto.request.ApiResponse;
import com.ngocha.identity_service.dto.request.AuthenticationRequest;
import com.ngocha.identity_service.dto.response.AuthenticationResponse;
import com.ngocha.identity_service.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;
@PostMapping("/login")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
    boolean result = authenticationService.authenticate(authenticationRequest);
    return ApiResponse.<AuthenticationResponse>builder().code(200).result(AuthenticationResponse.builder()
            .Authenticated(result).build()).build();
}
}
