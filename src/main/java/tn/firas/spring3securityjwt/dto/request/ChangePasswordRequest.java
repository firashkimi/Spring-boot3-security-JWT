package tn.firas.spring3securityjwt.dto.request;

public record ChangePasswordRequest(
        String currentPassword,
        String newPassword,
        String confirmationPassword
) {
}
