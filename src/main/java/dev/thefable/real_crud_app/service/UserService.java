package dev.thefable.real_crud_app.service;

import dev.thefable.real_crud_app.model.User;
import dev.thefable.real_crud_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        user.setId(0);
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getOneUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(int id, User user) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());

        return userRepository.save(existing);
    }


    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User with id " + id + " deleted";
    }
}
