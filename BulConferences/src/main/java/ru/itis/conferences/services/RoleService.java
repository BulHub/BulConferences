package ru.itis.conferences.services;

import ru.itis.conferences.models.Role;

import java.util.Optional;

public interface RoleService {
    Role save(Role role);

    Optional<Role> findByName(String name);
}
