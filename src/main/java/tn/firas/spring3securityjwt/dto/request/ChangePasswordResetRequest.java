package tn.firas.spring3securityjwt.dto.request;

public record ChangePasswordResetRequest(
        String newPassword,
        String confirmationPassword
) {
}
