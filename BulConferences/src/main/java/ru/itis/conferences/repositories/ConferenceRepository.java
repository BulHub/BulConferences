package ru.itis.conferences.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.conferences.models.Conference;

import java.util.Optional;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    Optional<Conference> findByName(String name);
}
