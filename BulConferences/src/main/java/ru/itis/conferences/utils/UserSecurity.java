package ru.itis.conferences.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.itis.conferences.models.User;
import ru.itis.conferences.services.UserService;

import java.util.Optional;

@Component
public class UserSecurity {

    private final UserService userService;

    @Autowired
    public UserSecurity(UserService userService){
        this.userService = userService;
    }

    public User getUserByEmailWithSpringSecurity(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> optionalUser = userService.findByEmail(auth.getName());
        return optionalUser.get();
    }
}
