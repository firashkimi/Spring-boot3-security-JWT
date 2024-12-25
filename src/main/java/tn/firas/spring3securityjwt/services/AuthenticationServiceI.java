package tn.firas.spring3securityjwt.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tn.firas.spring3securityjwt.dto.request.AuthenticationRequest;
import tn.firas.spring3securityjwt.dto.request.RegistrationRequest;
import tn.firas.spring3securityjwt.dto.response.AuthenticationResponse;

import java.io.IOException;

public interface AuthenticationServiceI {
    AuthenticationResponse register(RegistrationRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException;
}
