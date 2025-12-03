package io.github.alisa_salimianova.pmapi.service;

import io.github.alisa_salimianova.pmapi.dto.AuthResponse;
import io.github.alisa_salimianova.pmapi.dto.LoginRequest;
import io.github.alisa_salimianova.pmapi.dto.RegisterRequest;
import io.github.alisa_salimianova.pmapi.entity.User;
import io.github.alisa_salimianova.pmapi.repository.UserRepository;
import io.github.alisa_salimianova.pmapi.security.JwtProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    public AuthResponse register(RegisterRequest req) {
        if (userRepository.existsByEmail(req.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }
        User user = new User();
        user.setEmail(req.getEmail());
        user.setFullName(req.getFullName());
        user.setPasswordHash(passwordEncoder.encode(req.getPassword()));
        userRepository.save(user);
        String token = jwtProvider.generateToken(user.getId(), user.getEmail());
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest req) {
        Optional<User> maybe = userRepository.findByEmail(req.getEmail());
        if (maybe.isEmpty()) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        User user = maybe.get();
        if (!passwordEncoder.matches(req.getPassword(), user.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        String token = jwtProvider.generateToken(user.getId(), user.getEmail());
        return new AuthResponse(token);
    }
}
