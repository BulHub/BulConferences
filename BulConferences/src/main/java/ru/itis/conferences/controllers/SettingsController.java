package ru.itis.conferences.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.conferences.dto.PasswordDto;
import ru.itis.conferences.services.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class SettingsController {

    private final UserService userService;

    @Autowired
    public SettingsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/changePassword")
    public String getChangePassword(){
        return "changePassword";
    }

    @PostMapping("/changePassword")
    public String changePassword(PasswordDto passwordDto, ModelMap model, HttpSession session){
        userService.changePassword(passwordDto, model, session);
        return "changePassword";
    }
}
