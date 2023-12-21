package com.clinicappbdas2.model.request;

import lombok.Value;

@Value
public class ChangeUserZamIdRequest {
    Integer userId;
    Integer newZamId;
}
