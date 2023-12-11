package com.clinicappbdas2.model.request;

import com.clinicappbdas2.model.security.UserRole;
import lombok.Value;

@Value
public class RegisterRequest {
    String username;
    String password;
    String role;
}