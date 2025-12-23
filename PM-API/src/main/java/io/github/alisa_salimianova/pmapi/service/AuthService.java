package io.github.alisa_salimianova.pmapi.service;

import io.github.alisa_salimianova.pmapi.dto.auth.LoginRequest;
import io.github.alisa_salimianova.pmapi.dto.auth.RegisterRequest;
import io.github.alisa_salimianova.pmapi.dto.auth.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}
