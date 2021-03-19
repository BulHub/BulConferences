package ru.itis.conferences.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.conferences.models.Audience;
import ru.itis.conferences.repositories.AudienceRepository;
import ru.itis.conferences.services.AudienceService;

import java.util.List;
import java.util.Optional;

@Service
public class AudienceServiceImpl implements AudienceService {

    private final AudienceRepository audienceRepository;

    @Autowired
    public AudienceServiceImpl(AudienceRepository audienceRepository) {
        this.audienceRepository = audienceRepository;
    }

    @Override
    public List<Audience> findAll() {
        return audienceRepository.findAll();
    }

    @Override
    public Optional<Audience> findByNumber(Long number) {
        return audienceRepository.findByNumber(number);
    }

    @Override
    public void delete(Audience entity) {
        audienceRepository.delete(entity);
    }

    @Override
    public void add(Audience entity) {
        audienceRepository.save(entity);
    }
}
