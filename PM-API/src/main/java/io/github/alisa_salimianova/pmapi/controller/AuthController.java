package io.github.alisa_salimianova.pmapi.controller;

import io.github.alisa_salimianova.pmapi.dto.auth.LoginRequest;
import io.github.alisa_salimianova.pmapi.dto.auth.RegisterRequest;
import io.github.alisa_salimianova.pmapi.dto.auth.AuthResponse;
import io.github.alisa_salimianova.pmapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request
    ) {
        return ResponseEntity.ok(authService.login(request));
    }
}
