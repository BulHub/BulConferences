package ru.itis.conferences.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.conferences.models.Audience;

import java.util.Optional;

@Repository
public interface AudienceRepository extends JpaRepository<Audience, Long> {
    Optional<Audience> findByNumber(Long number);
}
