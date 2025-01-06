package tn.firas.spring3securityjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.firas.spring3securityjwt.entities.ForgotPasswordToken;
import tn.firas.spring3securityjwt.entities.User;

import java.util.Optional;

public interface ForgotPasswordTokenRepository extends JpaRepository<ForgotPasswordToken, Long> {
    @Query("select fpt from ForgotPasswordToken fpt where fpt.token = ?1 and fpt.user = ?2 ")
    Optional<ForgotPasswordToken> findByTokenAndUser(String token, User user);

    @Query("select fpt from ForgotPasswordToken fpt where fpt.user = ?1 ")
    Optional<ForgotPasswordToken> findByUser(User user);
}