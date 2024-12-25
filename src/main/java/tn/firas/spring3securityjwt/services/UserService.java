package tn.firas.spring3securityjwt.services;

import tn.firas.spring3securityjwt.dto.request.ChangePasswordRequest;

import java.security.Principal;

public interface UserService {
    void changePassword(ChangePasswordRequest request, Principal connectedUser);
}
