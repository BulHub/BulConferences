package ru.itis.conferences.services;

import org.springframework.stereotype.Service;
import ru.itis.conferences.models.Audience;

import java.util.List;
import java.util.Optional;

@Service
public interface AudienceService {
    List<Audience> findAll();

    Optional<Audience> findByNumber(Long number);

    void delete(Audience entity);

    void add(Audience entity);
}
