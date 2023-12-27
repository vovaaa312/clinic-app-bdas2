package com.clinicappbdas2.model.request;

import lombok.Value;

import java.util.Date;

@Value
public class PrumVekRequest {
    Date    datumOd;
    Date    datumDo;
    String  pohlavi;
}
