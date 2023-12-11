package com.clinicappbdas2.model.request;

import lombok.Value;

@Value
public class ChangeRoleRequest {

    Integer userId;

    String roleName;
}
