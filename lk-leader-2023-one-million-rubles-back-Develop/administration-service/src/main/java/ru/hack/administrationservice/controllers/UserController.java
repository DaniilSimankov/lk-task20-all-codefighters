package ru.hack.administrationservice.controllers;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.hack.administrationservice.models.user.User;
import ru.hack.administrationservice.repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/helper/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteUserById(@RequestParam("id") String id) {
        userRepository.delete(userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException();
        }));

        return "User with id " + id + " was deleted";
    }

}
