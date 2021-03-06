package ru.itis.conferences.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import ru.itis.conferences.dto.PasswordDto;
import ru.itis.conferences.models.Role;
import ru.itis.conferences.models.Status;
import ru.itis.conferences.models.User;
import ru.itis.conferences.repositories.UserRepository;
import ru.itis.conferences.services.RoleService;
import ru.itis.conferences.services.UserService;
import ru.itis.conferences.utils.Attributes;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findByToken(String token) {
        return userRepository.findByToken(token);
    }

    @Override
    public void signUp(User user, HttpSession session) {
        Optional<Role> roleUser = roleService.findByName("ROLE_LISTENER");
        roleUser.ifPresent(role -> user.setRoles(Collections.singletonList(role)));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(Status.INACTIVE);
        user.setCreated(new Date());
        user.setUpdated(new Date());
        user.setToken(generateNewToken());
        save(user);
        session.setAttribute("nickname", user.getNickname());
        session.setAttribute("email", user.getEmail());
    }

    private static String generateNewToken() {
        int length = 500;
        Random r = new Random();
        return r.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean confirm(String token) {
        Optional<User> optionalUser = findByToken(token);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setStatus(Status.ACTIVE);
            save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void changePassword(PasswordDto passwordDto, ModelMap model, HttpSession session){
        String email = (String) session.getAttribute("email");
        User user = findByEmail(email).orElse(new User());
        String newPassword = user.getPassword();
        if (!passwordEncoder.matches(passwordDto.getOldPassword(), newPassword)){
            Attributes.addErrorAttributes(model, "Wrong old password!");
        }else{
            user.setPassword(newPassword);
            userRepository.save(user);
            Attributes.addSuccessAttributes(model, "Success!");
        }
    }

    @Override
    public List<User> findByRoles(Role role){
        return userRepository.findByRoles(role);
    }

    @Override
    public boolean createNewUserWithRole(User user, String role){
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()){
            return false;
        }else{
            user.setRoles(Collections.singletonList(roleService.findByName(role).get()));
            user.setStatus(Status.ACTIVE);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setCreated(new Date());
            user.setUpdated(new Date());
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public void delete(User user){
        userRepository.delete(user);
    }

    @Override
    public boolean updateRole(String email, String role){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        Optional<Role> optionalRole = roleService.findByName(role);
        if (optionalRole.isPresent() && optionalUser.isPresent()){
            User user = optionalUser.get();
            Role newRole = optionalRole.get();
            List<Role> arrayList = new ArrayList();
            arrayList.add(newRole);
            user.setRoles(arrayList);
            userRepository.save(user);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateUser(User user){
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (!optionalUser.isPresent()){
            return false;
        }else{
            User oldUSer = optionalUser.get();
            if (!user.getNickname().equals("")){
                oldUSer.setNickname(user.getNickname());
            }
            if (!user.getPassword().equals("")){
                oldUSer.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            userRepository.save(oldUSer);
            return true;
        }
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }
}