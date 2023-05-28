package ru.lk.task20.authserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.lk.task20.authserver.model.User;
import ru.lk.task20.authserver.repository.UserCredentialsRepository;

import java.util.List;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserCredentialsRepository userCredentialsRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;

    private final List<String> profanityWords = List.of("непристойное_слово1", "непристойное_слово2", "непристойное_слово3");
    private final Pattern cyrillicPattern = Pattern.compile("^[а-яА-Я]+$");

    public boolean registerNewUser(User user) {
        if (userCredentialsRepository.existsByEmail(user.getEmail()) ||
                userCredentialsRepository.existsByPhone(user.getPhone())) {
            throw new RuntimeException("User already exists");
        }
        if (!validatePhoneNumber(user.getPhone())) {
            throw new RuntimeException("Invalid phone number");
        }

        validateNameAndSurname(user.getFirstName(), user.getSecondName());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userCredentialsRepository.insert(user);
        return true;
    }

    public String authenticateUser(String email, String password) {
        User user = userCredentialsRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return generateToken(user.getId(), user.getRole().getRoleName());
        }
        throw new RuntimeException("Invalid credentials");
    }

    // HELP METHODS

    private String generateToken(String id, String role) {
        return jwtTokenService.generateToken(id, role);
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("^\\+7\\d{10}$")) {
            return false;
        }
        return true;
    }

    private void validateNameAndSurname(String name, String surname) {
        if (!isCyrillic(name) || !isCyrillic(surname) || containsProfanity(name) || containsProfanity(surname)) {
            throw new RuntimeException("Invalid name or surname");
        }
    }

    private boolean isCyrillic(String text) {
        return cyrillicPattern.matcher(text).matches();
    }

    private boolean containsProfanity(String text) {
        String lowercaseText = text.toLowerCase();
        for (String profanityWord : profanityWords) {
            if (lowercaseText.contains(profanityWord)) {
                return true;
            }
        }
        return false;
    }
}
