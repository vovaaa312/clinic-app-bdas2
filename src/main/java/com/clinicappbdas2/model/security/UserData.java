package com.clinicappbdas2.model.security;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserData {
    private final User user;
    private String accessToken;
}
