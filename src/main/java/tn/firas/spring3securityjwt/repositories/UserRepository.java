package tn.firas.spring3securityjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.firas.spring3securityjwt.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}