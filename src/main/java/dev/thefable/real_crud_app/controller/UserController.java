package dev.thefable.real_crud_app.controller;

import dev.thefable.real_crud_app.model.User;
import dev.thefable.real_crud_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable int id) {
        return userService.getOneUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}
