package ru.itis.conferences.services;

import ru.itis.conferences.models.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role save(Role role);
    List<Role> findAll();
    Optional<Role> findByName(String name);
}
