package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;


import java.util.List;


public interface RoleService {
    Role getRoleByName(String name);

    List<Role> getAllRoles();
}
