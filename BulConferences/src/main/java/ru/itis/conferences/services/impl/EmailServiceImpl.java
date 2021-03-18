package ru.itis.conferences.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import ru.itis.conferences.configuration.SenderConfig;
import ru.itis.conferences.models.User;
import ru.itis.conferences.services.EmailService;

@Service
@EnableAsync
public class EmailServiceImpl implements EmailService {

    private final SenderConfig senderConfig;

    @Value("${email.subject}")
    private String subjectEmail;

    @Value("${email.textRight}")
    private String textRight;

    @Autowired
    public EmailServiceImpl(SenderConfig senderConfig) {
        this.senderConfig = senderConfig;
    }

    @Override
    public void sendConfirmation(User user) {
        String mailText = "<a href='localhost:8080/token/" + user.getToken() + "'>" + textRight + "</a>";
        senderConfig.send(subjectEmail, mailText, user.getEmail());
    }
}