package com.clinicappbdas2.model.request;

import com.clinicappbdas2.model.security.UserRole;
import lombok.Setter;
import lombok.Value;

@Value
public class RegisterRequest {
    String login;
    String password;
    UserRole role;
}