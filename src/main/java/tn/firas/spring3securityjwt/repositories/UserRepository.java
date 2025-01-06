package tn.firas.spring3securityjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tn.firas.spring3securityjwt.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);

    @Modifying
    @Transactional
    @Query("update User u set u.password = ?2 where u.email = ?1 ")
    void updatePassword(String email, String password);
}