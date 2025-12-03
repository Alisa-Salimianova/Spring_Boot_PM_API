package io.github.alisa_salimianova.pmapi.controller;

import io.github.alisa_salimianova.pmapi.dto.AuthResponse;
import io.github.alisa_salimianova.pmapi.dto.LoginRequest;
import io.github.alisa_salimianova.pmapi.dto.RegisterRequest;
import io.github.alisa_salimianova.pmapi.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest req) {
        AuthResponse resp = authService.register(req);
        return ResponseEntity.status(201).body(resp);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {
        AuthResponse resp = authService.login(req);
        return ResponseEntity.ok(resp);
    }
}
