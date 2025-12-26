package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtTokenProvider {

    private static final String SECRET =
            "my-super-secret-key-my-super-secret-key";

    private static final long EXPIRATION = 1000 * 60 * 60;

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    // ================= TOKEN CREATION =================

    public String createToken(Long userId, String email, String role) {

        return Jwts.builder()
                .setSubject(email)
                .addClaims(Map.of(
                        "userId", userId,
                        "role", role
                ))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ================= TOKEN VALIDATION =================

    public Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // ================= METHODS REQUIRED BY TESTS =================

    public String getEmail(String token) {
        return validateToken(token).getSubject();
    }

    public Long getUserId(String token) {
        return validateToken(token).get("userId", Long.class);
    }

    public String getRole(String token) {
        return validateToken(token).get("role", String.class);
    }
}
