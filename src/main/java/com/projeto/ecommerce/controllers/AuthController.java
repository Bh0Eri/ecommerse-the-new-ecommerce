package com.projeto.ecommerce.controllers;


import com.projeto.ecommerce.dto.LoginDto;
import com.projeto.ecommerce.services.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController(value = "/jwt")
public class AuthController {

    JwtService jwtService;

    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        return jwtService.generateToken(loginDto.getEmail());
    }
}
