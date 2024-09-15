package ru.kata.spring.boot_security.demo.dbInit;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dao.RoleRepository;
import ru.kata.spring.boot_security.demo.model.Role;

@Component
public class RoleInitializer {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    @Transactional
    public void initRoles() {
        if (roleRepository.count() == 0) {
            Role adminRole = new Role("ROLE_ADMIN");
            Role userRole = new Role("ROLE_USER");

            roleRepository.save(adminRole);
            roleRepository.save(userRole);
        }
    }
}
