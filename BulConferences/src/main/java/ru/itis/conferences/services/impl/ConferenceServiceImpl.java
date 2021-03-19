package ru.itis.conferences.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.conferences.models.Conference;
import ru.itis.conferences.repositories.ConferenceRepository;
import ru.itis.conferences.services.ConferenceService;

import java.util.List;
import java.util.Optional;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    private final ConferenceRepository conferenceRepository;

    @Autowired
    public ConferenceServiceImpl(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @Override
    public List<Conference> findAll() {
        return conferenceRepository.findAll();
    }

    @Override
    public Optional<Conference> find(String name) {
        return conferenceRepository.findByName(name);
    }

    @Override
    public void delete(Conference entity) {
        conferenceRepository.delete(entity);
    }

    @Override
    public void add(Conference entity) {
        conferenceRepository.save(entity);
    }
}
