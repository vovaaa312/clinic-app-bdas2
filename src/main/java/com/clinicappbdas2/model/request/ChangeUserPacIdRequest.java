package com.clinicappbdas2.model.request;

import lombok.Value;

@Value
public class ChangeUserPacIdRequest {
    Integer userId;
    Integer newPacId;
}
