package ru.itis.conferences.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.conferences.dto.UserDto;
import ru.itis.conferences.models.User;
import ru.itis.conferences.services.RoleService;
import ru.itis.conferences.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin/users")
    public String getAdminPage(ModelMap map){
        List<User> users = userService.findByRoles(roleService.findByName("ROLE_LISTENER").get());
        map.put("userDtos", users.stream().map(UserDto::fromUser).collect(Collectors.toList()));
        return "users";
    }

    @PostMapping("/admin/users")
    public String remoteUser(@RequestParam("email") String email){
        //TODO: Как повысить роль?
        return "users";
    }
}
