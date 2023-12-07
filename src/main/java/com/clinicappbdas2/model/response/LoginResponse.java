package com.clinicappbdas2.model.response;

import com.clinicappbdas2.model.security.UserRole;

public class LoginResponse {

    private Integer id;
    private String login;
    private UserRole role;
    private Integer clientId;
    private String registeredByLogin;
    private String jwt;
    private String active;
    private String image;
}
