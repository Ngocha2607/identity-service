package com.ngocha.identity_service.controller;

import com.ngocha.identity_service.dto.request.ApiResponse;
import com.ngocha.identity_service.dto.request.AuthenticationRequest;
import com.ngocha.identity_service.dto.request.IntrospectRequest;
import com.ngocha.identity_service.dto.response.AuthenticationResponse;
import com.ngocha.identity_service.dto.response.IntrospectResponse;
import com.ngocha.identity_service.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@Controller
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;
@PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
    AuthenticationResponse result = authenticationService.authenticate(authenticationRequest);
    return ApiResponse.<AuthenticationResponse>builder().code(200).result(result  ).build();
}

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        IntrospectResponse result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder().code(200).result(result).build();
    }
}
