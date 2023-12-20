package com.clinicappbdas2.model.request;

import lombok.Value;

import java.util.Date;

@Value
public class RezervaceLuzkaRequest {
     Long  luzkoId;
     Long  pacientId;
     Date datumRezervace;
     Date datumPropusteni;
}