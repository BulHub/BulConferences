package ru.itis.conferences.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.itis.conferences.dto.UserDto;
import ru.itis.conferences.services.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{email}")
    public ResponseEntity<UserDto> getResumeByName(@PathVariable(name = "email") String email) {
        Optional<UserDto> user = userService.findByEmail(email).map(UserDto::fromUser);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getResumes() {
        List<UserDto> users = userService.findAll().stream()
                .map(UserDto::fromUser).collect(Collectors.toList());
        return users.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(users, HttpStatus.OK);
    }
}
