package io.github.alisa_salimianova.pmapi.service;

import io.github.alisa_salimianova.pmapi.dto.auth.AuthResponse;
import io.github.alisa_salimianova.pmapi.dto.auth.LoginRequest;
import io.github.alisa_salimianova.pmapi.dto.auth.RegisterRequest;
import io.github.alisa_salimianova.pmapi.entity.User;
import io.github.alisa_salimianova.pmapi.exception.ApiException;
import io.github.alisa_salimianova.pmapi.repository.UserRepository;
import io.github.alisa_salimianova.pmapi.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new ApiException("Email already in use", HttpStatus.BAD_REQUEST);
        }

        User user = User.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() ->
                        new ApiException("Invalid email or password", HttpStatus.UNAUTHORIZED)
                );

        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }
}
