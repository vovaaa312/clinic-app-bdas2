package com.clinicappbdas2.controller;

import com.clinicappbdas2.configuration.JwtTokenUtil;
import com.clinicappbdas2.model.request.LoginRequest;
import com.clinicappbdas2.model.request.RegisterRequest;
import com.clinicappbdas2.model.response.LoginResponse;
import com.clinicappbdas2.model.security.User;
import com.clinicappbdas2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/registration")
    public void register(@RequestBody RegisterRequest registerRequest) {
        final var encoded = new RegisterRequest(
                registerRequest.getLogin(),
                passwordEncoder.encode(registerRequest.getPassword()),
                registerRequest.getRole());
        userService.register(encoded);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(), request.getPassword()
                            )
                    );

            User user = (User) authenticate.getPrincipal();

            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.generateAccessToken(user))
                    .body(user);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
