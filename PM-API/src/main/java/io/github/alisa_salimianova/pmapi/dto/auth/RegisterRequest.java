package io.github.alisa_salimianova.pmapi.dto.auth;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
}
