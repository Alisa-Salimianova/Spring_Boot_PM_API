package io.github.alisa_salimianova.pmapi.service;

import io.github.alisa_salimianova.pmapi.dto.AuthResponse;
import io.github.alisa_salimianova.pmapi.dto.LoginRequest;
import io.github.alisa_salimianova.pmapi.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}
