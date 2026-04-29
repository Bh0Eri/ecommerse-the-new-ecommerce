package com.projeto.ecommerce.services.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final String SECRET = "Umpequenopassoparaumhomem,umsaltogigantescoparaahumanidade";

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
    }
}



