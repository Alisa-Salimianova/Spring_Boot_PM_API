package io.github.alisa_salimianova.pmapi.security;

public final class SecurityConstants {

    private SecurityConstants() {}

    public static final String[] AUTH_WHITELIST = {
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/api/v1/auth/**"
    };
}
