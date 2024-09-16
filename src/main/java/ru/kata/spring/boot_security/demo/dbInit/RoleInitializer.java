package ru.kata.spring.boot_security.demo.dbInit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RoleInitializer {

    @Autowired
    public RoleInitializer(RoleInitService roleInitService) {
        roleInitService.initRoles();
    }

}
