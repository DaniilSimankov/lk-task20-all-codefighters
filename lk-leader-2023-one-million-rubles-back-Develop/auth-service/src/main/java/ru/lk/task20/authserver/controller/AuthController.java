package ru.lk.task20.authserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.lk.task20.authserver.dto.AuthRequestDto;
import ru.lk.task20.authserver.model.User;
import ru.lk.task20.authserver.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean register(@RequestBody User user){
        return authenticationService.registerNewUser(user);
    }

    @PostMapping("/token")
    public String authenticate(@RequestBody AuthRequestDto authRequestDto){
        return authenticationService.authenticateUser(authRequestDto.getEmail(), authRequestDto.getPassword());
    }

}
