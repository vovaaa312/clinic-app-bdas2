package com.clinicappbdas2.model.request;

import lombok.Value;

import java.util.Date;

@Value
public class PridejLuzkoPacientoviRequest {
     int luzkoId;
     int pacientId;
     Date datumRezervace;
}
