package ru.lk.task20.authserver.controller;

import com.vk.api.sdk.client.actors.UserActor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.lk.task20.authserver.service.VKAuthService;

@RestController
@RequestMapping("/api/auth/vk")
@AllArgsConstructor
public class VKAuthController {
    private final VKAuthService vkAuthService;

    @GetMapping
    public String authenticate(@RequestParam("code") String code) throws Exception {
        UserActor actor = vkAuthService.authenticate(code);
        return "User authenticated: " + actor.getId();
    }
}