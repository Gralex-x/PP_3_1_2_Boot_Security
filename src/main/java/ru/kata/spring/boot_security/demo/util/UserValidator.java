package ru.kata.spring.boot_security.demo.util;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        if (!(target instanceof User user)) {
            throw new IllegalArgumentException("Target must be an instance of User");
        }

        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            errors.rejectValue("username", "", "Username is required");
        } else {
            try {
                userService.getUserByUsername(user.getUsername());
                errors.rejectValue("username", "", "Username is already taken");
                return;
            } catch (EntityNotFoundException ignored) {
            }
        }

        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            errors.rejectValue("password", "", "Password is required");
        }
    }
}
