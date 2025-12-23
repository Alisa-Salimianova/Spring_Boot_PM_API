package io.github.alisa_salimianova.pmapi.controller;

import io.github.alisa_salimianova.pmapi.dto.auth.AuthResponse;
import io.github.alisa_salimianova.pmapi.dto.auth.LoginRequest;
import io.github.alisa_salimianova.pmapi.dto.auth.RegisterRequest;
import io.github.alisa_salimianova.pmapi.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(
            @Valid @RequestBody RegisterRequest request
    ) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @Valid @RequestBody LoginRequest request
    ) {
        return authService.login(request);
    }
}
