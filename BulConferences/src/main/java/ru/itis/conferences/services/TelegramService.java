package ru.itis.conferences.services;

import org.springframework.stereotype.Service;
import ru.itis.conferences.models.Feedback;

@Service
public interface TelegramService {

    void sendMessageForFeedback(Feedback feedback);
}
