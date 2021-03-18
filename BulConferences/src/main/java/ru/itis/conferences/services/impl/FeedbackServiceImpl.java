package ru.itis.conferences.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.conferences.models.Feedback;
import ru.itis.conferences.repositories.FeedbackRepository;
import ru.itis.conferences.services.FeedbackService;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public Optional<Feedback> find(String email) {
        return feedbackRepository.findByEmail(email);
    }

    @Override
    public void delete(Feedback entity) {
        feedbackRepository.delete(entity);
    }

    @Override
    public void add(Feedback entity) {
        feedbackRepository.save(entity);
    }
}
