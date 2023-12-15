package com.clinicappbdas2.model.views;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PacientLuzko {
    private int idLuzko;
    private int idPokoj;
    private int idPacient;
    private String jmeno;
    private String prijmeni;
    private Date datumRezervace;
    private Date datumPropusteni;
    private boolean status;
    private int cislo;
    private int patro;

    private String nazevOddeleni;

}
