package ru.itis.conferences.services;

import org.springframework.stereotype.Service;
import ru.itis.conferences.dto.ConferenceDto;
import ru.itis.conferences.models.Conference;

import java.util.List;
import java.util.Optional;

@Service
public interface ConferenceService {
    List<Conference> findAll();

    Optional<Conference> find(String name);

    void delete(Conference entity);

    void add(Conference entity);

    boolean signUpForConference(String name);

    List<ConferenceDto> getAllConferencesWhereThisUserIsRegistered();

    List<ConferenceDto> getAllConferencesWhereThisUserIsNotRegistered();
}
