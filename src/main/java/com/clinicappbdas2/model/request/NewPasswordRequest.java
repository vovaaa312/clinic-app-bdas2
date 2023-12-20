package com.clinicappbdas2.model.request;

import lombok.Value;

@Value
public class NewPasswordRequest {
    Long id;
    String password;
}