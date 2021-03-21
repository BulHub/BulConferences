package ru.itis.conferences.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.conferences.dto.ConferenceDto;
import ru.itis.conferences.models.Conference;
import ru.itis.conferences.models.User;
import ru.itis.conferences.repositories.ConferenceRepository;
import ru.itis.conferences.services.ConferenceService;
import ru.itis.conferences.utils.UserSecurity;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    private final ConferenceRepository conferenceRepository;
    private final UserSecurity userSecurity;

    @Autowired
    public ConferenceServiceImpl(ConferenceRepository conferenceRepository, ru.itis.conferences.services.UserService userService, UserSecurity userSecurity) {
        this.conferenceRepository = conferenceRepository;
        this.userSecurity = userSecurity;
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

    @Override
    public boolean signUpForConference(String name) {
        Optional<Conference> optionalConference = conferenceRepository.findByName(name);
        if (optionalConference.isPresent()){
            Conference conference = optionalConference.get();
            User user = userSecurity.getUserByEmailWithSpringSecurity();
            Set<User> users = conference.getUsers();
            users.add(user);
            conferenceRepository.save(conference);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<ConferenceDto> getAllConferencesWhereThisUserIsRegistered() {
        User user = userSecurity.getUserByEmailWithSpringSecurity();
        List<Conference> conferences = conferenceRepository.findAll();
        List<Conference> isRegisteredConferences = conferences.stream()
                .filter(conference -> conference.getUsers().contains(user))
                .collect(Collectors.toList());
        return isRegisteredConferences.stream().map(ConferenceDto::fromConference).collect(Collectors.toList());
    }

    @Override
    public List<ConferenceDto> getAllConferencesWhereThisUserIsNotRegistered() {
        User user = userSecurity.getUserByEmailWithSpringSecurity();
        List<Conference> conferences = conferenceRepository.findAll();
        List<Conference> isNotRegisteredConferences = conferences.stream()
                .filter(conference -> !conference.getUsers().contains(user))
                .collect(Collectors.toList());
        return isNotRegisteredConferences.stream().map(ConferenceDto::fromConference).collect(Collectors.toList());
    }
}
