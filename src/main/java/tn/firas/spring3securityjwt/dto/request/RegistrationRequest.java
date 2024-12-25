package tn.firas.spring3securityjwt.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import tn.firas.spring3securityjwt.entities.Role;

public record RegistrationRequest(
        @NotBlank(message = "This field cannot be blank or contain only spaces.")
        String username,
        @NotNull(message = "This field cannot be null.")
        String firstname,
        String lastname,
        @NotNull(message = "This field cannot be null.")
        @NotEmpty
        @Email(message =
                "The email address is not valid. Please ensure it follows the correct format (e.g., example@domain.com).")
        @Schema(
                description = "User password. Must contain at least one uppercase letter, one lowercase letter, one number, one special character, and be at least 6 characters long.",
                example = "*@gmail.com",
                type = "string",
                format = "password"
        )

        String email,

        @Size(min = 6, message = "Password must be at least 6 characters long.")
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
                message = "Password must have at least one uppercase letter, one lowercase letter, "
                        + "one number, and one special character."
        )
        @Schema(
                description = "User password. Must contain at least one uppercase letter, one lowercase letter, one number, one special character, and be at least 6 characters long.",
                example = "********",
                type = "string",
                format = "password"
        )
        String password,
        Role role
) {
}
