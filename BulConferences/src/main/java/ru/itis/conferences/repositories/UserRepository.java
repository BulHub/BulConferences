package ru.itis.conferences.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.conferences.models.Role;
import ru.itis.conferences.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByToken(String token);
    Optional<User> findByEmail(String email);
    List<User> findByRoles(Role role);
}
