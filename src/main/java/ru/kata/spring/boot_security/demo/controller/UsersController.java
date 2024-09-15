package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.security.UserDetailsImpl;

@Controller
@RequestMapping("/user")
public class UsersController {


    @GetMapping()
    public String user(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        model.addAttribute("user", userDetails.user());
        return "userPages/user";
    }

//    @GetMapping("/users/new")
//    public String newUser(@ModelAttribute("user") User user) {
//        return "users/newUser";
//    }
//
//    @PostMapping("/users")
//    public String createUser(@ModelAttribute("user") User user) {
//        userService.addUser(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping(value = "/users/edit", params = "id")
//    public String editUser(@RequestParam("id") Long id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "users/editUser";
//    }
//
//    @PostMapping(value = "/users/update", params = "id")
//    public String updateUser(@ModelAttribute("user") User user) {
//        userService.updateUser(user);
//        return "redirect:/users";
//    }
//
//    @PostMapping(value = "/users/delete", params = "id")
//    public String deleteUser(@RequestParam("id") Long id) {
//        userService.deleteUser(id);
//        return "redirect:/users";
//    }

}
