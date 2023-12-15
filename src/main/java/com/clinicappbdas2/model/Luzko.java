package com.clinicappbdas2.model;

import lombok.Data;

import java.util.Date;

@Data
public class Luzko {
    private int idLuzko;
    private int idPokoj;
    private int idPacient;
    private Date datumRezervace;
    private Date datumPropusteni;
    private boolean status;
    private int cislo;
}
