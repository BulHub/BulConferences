package ru.itis.conferences.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import ru.itis.conferences.dto.PasswordDto;
import ru.itis.conferences.models.Report;
import ru.itis.conferences.models.User;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public interface UserService {
    Optional<User> findByEmail(String email);

    Optional<User> findByToken(String token);

    void signUp(User user, HttpSession session);

    User save(User user);

    boolean confirm(String token);

    void changePassword(PasswordDto passwordDto, ModelMap model, HttpSession session);
}
