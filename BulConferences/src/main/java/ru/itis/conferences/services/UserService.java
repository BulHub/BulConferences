package ru.itis.conferences.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import ru.itis.conferences.dto.PasswordDto;
import ru.itis.conferences.models.Role;
import ru.itis.conferences.models.User;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Optional<User> findByEmail(String email);

    Optional<User> findByToken(String token);

    void signUp(User user, HttpSession session);

    List<User> findByRoles(Role role);

    User save(User user);

    void delete(User user);

    boolean createNewUserWithRole(User user, String role);

    boolean confirm(String token);

    void changePassword(PasswordDto passwordDto, ModelMap model, HttpSession session);

    boolean updateRole(String email, String role);

    boolean updateUser(User user);
}
