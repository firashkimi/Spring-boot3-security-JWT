package tn.firas.spring3securityjwt.dto.request;

public record AuthenticationRequest(
        String email,
        String password
) {
}


