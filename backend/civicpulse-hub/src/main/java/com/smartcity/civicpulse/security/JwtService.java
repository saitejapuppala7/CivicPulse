package com.smartcity.civicpulse.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;

import static java.security.KeyRep.Type.SECRET;
@Service
public class JwtService {

    private final String SECRET="my_civicpulse_key_9676";
    public String generateToken(String email,String role)
    {
        return  JWT.create()
            .withSubject(email)
            .withClaim("role", role)
            .withIssuedAt(new Date())
            .withExpiresAt(new Date(System.currentTimeMillis() + 86400000))
            .sign(Algorithm.HMAC256(SECRET));
    }
    public String extractEmail(String token) {
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token);
        return jwt.getSubject();
    }


    public boolean isTokenValid(String token) {
        try {
            JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public String extractRole(String token) {
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token);
        return jwt.getClaim("role").asString();
    }

    }

