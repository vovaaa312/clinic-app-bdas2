package com.clinicappbdas2.model.request;

import lombok.Value;

import java.util.Date;

@Value
public class RezervaceLuzkaRequest {
     int  luzkoId;
     int  pacientId;
     Date datumRezervace;
     Date datumPropusteni;
}
