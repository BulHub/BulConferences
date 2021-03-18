package ru.itis.conferences.services;

import org.springframework.stereotype.Service;
import ru.itis.conferences.models.Feedback;

import java.util.List;
import java.util.Optional;

@Service
public interface FeedbackService {
    List<Feedback> findAll();

    Optional<Feedback> find(String email);

    void delete(Feedback entity);

    void add(Feedback entity);
}
