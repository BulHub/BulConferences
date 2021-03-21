package ru.itis.conferences.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.conferences.dto.UserDto;
import ru.itis.conferences.models.User;
import ru.itis.conferences.services.RoleService;
import ru.itis.conferences.services.UserService;
import ru.itis.conferences.utils.Attributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin/users")
    public String getAdminPage(ModelMap map) {
        List<User> users = userService.findByRoles(roleService.findByName("ROLE_LISTENER").get());
        map.put("userDtos", users.stream().map(UserDto::fromUser).collect(Collectors.toList()));
        return "users";
    }

    @PostMapping("/admin/users")
    public String remoteUser(@RequestParam("email") String email,
                             RedirectAttributes redirectAttributes) {
        if (userService.updateRole(email, "ROLE_PRESENTER")){
            Attributes.addSuccessAttributesWithFlash(redirectAttributes, "Success");
        }else{
            Attributes.addErrorAttributesWithFlash(redirectAttributes, "Error!");
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/creature")
    public String getPageForCreateUser(ModelMap map) {
        map.put("roles", roleService.findAll());
        return "creature";
    }

    @PostMapping("/admin/creature")
    public String addNewUser(@RequestParam("role1") String role,
                             RedirectAttributes redirectAttributes, User user) {
        if (!userService.createNewUserWithRole(user, role)) {
            Attributes.addErrorAttributesWithFlash(redirectAttributes, "This email is already taken!");
        } else {
            Attributes.addSuccessAttributesWithFlash(redirectAttributes, "Success");
        }
        return "redirect:/admin/creature";
    }

    @PostMapping("/admin/delete")
    public String getPageForDeleteUser(@RequestParam("email") String email,
                                       RedirectAttributes redirectAttributes){
        Optional<User> optionalUser = userService.findByEmail(email);
        if (optionalUser.isPresent()){
            userService.delete(optionalUser.get());
            Attributes.addSuccessAttributesWithFlash(redirectAttributes, "Success");
        }else{
            Attributes.addErrorAttributesWithFlash(redirectAttributes, "Error!");
        }
        return "redirect:/admin/users";
    }
}
