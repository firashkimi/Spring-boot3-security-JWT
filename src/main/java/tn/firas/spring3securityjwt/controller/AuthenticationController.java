package tn.firas.spring3securityjwt.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.firas.spring3securityjwt.dto.request.AuthenticationRequest;
import tn.firas.spring3securityjwt.dto.request.RegistrationRequest;
import tn.firas.spring3securityjwt.dto.response.AuthenticationResponse;
import tn.firas.spring3securityjwt.services.AuthenticationServiceI;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationServiceI service;

    @PostMapping("/register")
    @Operation(
            description = "Register endpoint",
            summary = "This is for Register endpoint"

    )
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(
            @RequestBody @Valid RegistrationRequest request
    )throws MessagingException {
        service.register(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/authenticate")
    @Operation(
            description = "Authenticate endpoint",
            summary = "This is for Authenticate endpoint"

    )
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/activate-account")
    public void confirm(
            @RequestParam String token
    ) throws MessagingException {
        service.activateAccount(token);
    }

    @PostMapping("/refresh-token")
    @Operation(
            description = "Refresh Token endpoint",
            summary = "This is for Refresh Token endpoint"

    )
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }


}
