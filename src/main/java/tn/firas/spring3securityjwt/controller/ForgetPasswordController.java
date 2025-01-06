package tn.firas.spring3securityjwt.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.firas.spring3securityjwt.dto.request.ChangePasswordResetRequest;
import tn.firas.spring3securityjwt.dto.response.Response;
import tn.firas.spring3securityjwt.services.PasswordResetTokenService;

@RestController
@RequestMapping("/forget")
@RequiredArgsConstructor
@Tag(name = "Forget Password")
public class ForgetPasswordController {
    private final PasswordResetTokenService passwordResetTokenService;



    //send mail for email verification
    @Operation(
            description = "Step 1:  Send Email for email verification endpoint",
            summary = "Step 1: This is for Send Email for email verification endpoint"

    )
    @PostMapping("/verifyMail/{email}")
    public ResponseEntity<Response> verifyEmail(@PathVariable String email) throws MessagingException {

        return passwordResetTokenService.verifyEmail(email);

    }

    @Operation(
            description = "Step 2:  Verify OTP endpoint",
            summary = "Step 2: This is for OTP verification endpoint"

    )
    @PostMapping("/verifyOtp/{otp}/{email}")
    public ResponseEntity<Response> verifyOtp(@PathVariable String otp,@PathVariable String email) throws MessagingException {
        return passwordResetTokenService.verifyOtp(otp, email);
    }

    //Now User Can change the password

    @Operation(
            description = "Step 3:  User Change Password endpoint",
            summary = "Step 3: This is for User Change Password  endpoint"

    )
    @PostMapping("/changePassword/{email}")
    public ResponseEntity<Response> changePasswordHandler(
            @RequestBody ChangePasswordResetRequest changePassword,
            @PathVariable String email
    ){
        return passwordResetTokenService.changePasswordHandler(changePassword,email);
    }

}