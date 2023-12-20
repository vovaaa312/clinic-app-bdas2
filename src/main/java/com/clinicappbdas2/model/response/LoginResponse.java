package com.clinicappbdas2.model.response;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Data
public class LoginResponse {

  private final Long userId;
  private final String login;
  private final String roleName;
  private final  String jwt;
  private final Long pacId;
  private final Long zamId;
}
