package com.clinicappbdas2.model.request;

import lombok.Value;

@Value
public class LoginRequest {
    String username;
    String password;
}
