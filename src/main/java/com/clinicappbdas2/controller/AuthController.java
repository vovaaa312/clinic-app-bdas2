package com.clinicappbdas2.controller;

import com.clinicappbdas2.configuration.JwtTokenUtil;
import com.clinicappbdas2.model.request.LoginRequest;
import com.clinicappbdas2.model.request.RegisterRequest;
import com.clinicappbdas2.model.response.LoginResponse;
import com.clinicappbdas2.model.security.User;
import com.clinicappbdas2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;

    @PostMapping("/registration")
    public void register(@RequestBody RegisterRequest registerRequest) {
        userService.register(registerRequest);
    }


    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getLogin(), request.getPassword()
                            )
                    );

            User user = (User) authenticate.getPrincipal();

            user.setPacientId(userService.getById(user.getId()).getPacientId());
            user.setZamestnanecId(userService.getById(user.getId()).getZamestnanecId());

            var jwtToken = jwtTokenUtil.generateAccessToken(user);
            return LoginResponse.builder()
                    .userId(user.getId())
                    .login(user.getLogin())
                    .roleName(user.getRoleName())
                    .jwt(jwtToken)
                    .pacId(user.getPacientId())
                    .zamId(user.getZamestnanecId())
                    .build();
        } catch (BadCredentialsException ex) {
            return null;
        }
    }

    @PreAuthorize("hasRole('ADMIN')") // Проверка, что пользователь является администратором
    @PostMapping("/changeUserRole")
    public ResponseEntity<?> changeUserRole(@RequestParam int userId, @RequestParam String roleName) {
        try {
            userService.changeUserRole(userId, roleName);
            return ResponseEntity.ok().body("User role successfully updated.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
