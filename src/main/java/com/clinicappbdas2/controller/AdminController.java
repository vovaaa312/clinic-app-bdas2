package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.security.User;
import com.clinicappbdas2.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public AdminController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/switchUser")
    public ResponseEntity<?> switchUser(@RequestParam String username) {
        User userToEmulate = userService.getUserByLogin(username);
        if (userToEmulate == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        // Эмулируем аутентификацию как другой пользователь
        Authentication auth = new UsernamePasswordAuthenticationToken(userToEmulate, null, userToEmulate.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

        return ResponseEntity.ok("Switched to user: " + username);
    }
}
