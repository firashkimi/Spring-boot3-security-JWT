package tn.firas.spring3securityjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.firas.spring3securityjwt.entities.Token;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByToken(String token);
}
