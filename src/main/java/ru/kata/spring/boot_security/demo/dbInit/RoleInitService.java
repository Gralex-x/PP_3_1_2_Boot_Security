package ru.kata.spring.boot_security.demo.dbInit;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleRepository;
import ru.kata.spring.boot_security.demo.model.Role;

@Service
public class RoleInitService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleInitService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

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
