package ru.itis.conferences.services;

import org.springframework.stereotype.Service;
import ru.itis.conferences.models.User;

@Service
public interface EmailService {
    void sendConfirmation(User user);
}
